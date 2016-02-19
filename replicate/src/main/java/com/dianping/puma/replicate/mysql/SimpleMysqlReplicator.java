package com.dianping.puma.replicate.mysql;

import com.dianping.puma.common.model.BinlogCursor;
import com.dianping.puma.common.model.BinlogServer;
import com.dianping.puma.common.mysql.QueryExecutor;
import com.dianping.puma.common.mysql.ResultSet;
import com.dianping.puma.common.mysql.packet.*;
import com.dianping.puma.replicate.AbstractPumaReplicator;
import com.dianping.puma.replicate.exception.*;
import com.dianping.puma.replicate.mysql.constant.BinlogFormat;
import com.dianping.puma.replicate.mysql.constant.BinlogRowImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaotian.li on 16/2/16.
 * Email: lixiaotian07@gmail.com
 */
public class SimpleMysqlReplicator extends AbstractPumaReplicator {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String cluster;

    private Set<String> databases;

    private BinlogServer binlogServer;

    private BinlogCursor binlogCursor;

    private long connectTimeoutInSecond = 10;

    private Socket socket;

    private InputStream inputStream;

    private OutputStream outputStream;

    private PumaContext context = new PumaContext();

    @Override
    public ByteBuffer replicate() throws PumaReplicateException {
        return null;
    }

    @Override
    public void start() {
        super.start();

        try {
            connect();
            login();
            setup();
            validate();
            dumpBinlog();
        } catch (Throwable t) {
            throw new PumaReplicateException("Failed to start replicator for " +
                    "cluster[%s] on binlog server[%s].", cluster, binlogServer, t);
        }
    }

    private void connect() throws IOException {
        logger.info("Start to connect to cluster[{}] on binlog server[{}].", cluster, binlogServer);

        socket = new Socket();
        socket.setKeepAlive(true);
        socket.setTcpNoDelay(false);

        String host = binlogServer.getHost();
        int port = binlogServer.getPort();
        socket.connect(new InetSocketAddress(host, port), (int) connectTimeoutInSecond);

        inputStream = new BufferedInputStream(socket.getInputStream());
        outputStream = new BufferedOutputStream(socket.getOutputStream());

        PacketFactory.parsePacket(inputStream, PacketType.CONNECT_PACKET, context);

        logger.info("Success to connect to cluster[{}] on binlog server[{}].", cluster, binlogServer);
    }

    private void login() throws IOException {
        logger.info("Start to login cluster[{}] on binlog server[{}].", cluster, binlogServer);

        AuthenticatePacket authPacket = (AuthenticatePacket) PacketFactory.createCommandPacket(
                PacketType.AUTHENTICATE_PACKET, context);

        authPacket.setUser(binlogServer.getBinlogUsername());
        authPacket.setPassword(binlogServer.getBinlogPassword());
        authPacket.buildPacket(context);
        authPacket.write(outputStream, context);

        OKErrorPacket okErrorPacket = (OKErrorPacket) PacketFactory.parsePacket(
                inputStream, PacketType.OKERROR_PACKET, context);
        if (!okErrorPacket.isOk()) {
            throw new BinlogAuthException(okErrorPacket.getMessage());
        }

        logger.info("Success to login cluster[{}] on binlog server[{}].", cluster, binlogServer);
    }

    private void setup() throws IOException {
        logger.info("Start to setup cluster[{}] on binlog server[{}].", cluster, binlogServer);

        QueryCommandPacket packet = (QueryCommandPacket) PacketFactory.createCommandPacket(
                PacketType.QUERY_COMMAND_PACKET, context);

        packet.setQueryString("set @master_binlog_checksum= '@@global.binlog_checksum'");
        packet.buildPacket(context);
        packet.write(outputStream, context);

        OKErrorPacket okErrorPacket = (OKErrorPacket) PacketFactory.parsePacket(
                inputStream, PacketType.OKERROR_PACKET, context);
        if (!okErrorPacket.isOk()) {
            throw new BinlogSetupException(okErrorPacket.getMessage());
        }

        logger.info("Success to setup cluster[{}] on binlog server[{}].", cluster, binlogServer);
    }

    private void validate() throws IOException {
        logger.info("Start to validate cluster[{}] on binlog server[{}].", cluster, binlogServer);

        validateBinlogFormat();
        validateBinlogImage();

        logger.info("Success to validate cluster[{}] on binlog server[{}].", cluster, binlogServer);
    }

    private void validateBinlogFormat() throws IOException {
        QueryExecutor executor = new QueryExecutor(inputStream, outputStream);
        String cmd = "show global variables like 'binlog_format'";
        ResultSet rs = executor.query(cmd, context);
        List<String> columnValues = rs.getFiledValues();

        boolean isQuery = true;
        if (columnValues == null || columnValues.size() != 2 || columnValues.get(1) == null) {
            throw new IllegalBinlogFormatException();
        }
        BinlogFormat binlogFormat = BinlogFormat.valueOf(columnValues.get(1));
        if (binlogFormat == null || !binlogFormat.isRow()) {
            throw new IllegalBinlogFormatException();
        }
    }

    private void validateBinlogImage() throws IOException {
        QueryExecutor executor = new QueryExecutor(inputStream, outputStream);
        String cmd = "show variables like 'binlog_row_image'";
        ResultSet rs = executor.query(cmd, context);
        List<String> columnValues = rs.getFiledValues();
        boolean isQuery = true;
        if (columnValues == null || columnValues.size() == 0) {// 5.1
            isQuery = true;
        } else if (columnValues != null && columnValues.size() == 2 && columnValues.get(1) != null) {// 5.6
            BinlogRowImage binlogRowImage = BinlogRowImage.valueOf(columnValues.get(1));
            isQuery = true;
            if (binlogRowImage == null || !binlogRowImage.isFull()) {
                throw new IllegalBinlogImageException();
            }
        } else {
            throw new IllegalBinlogImageException();
        }
    }

    private void dumpBinlog() throws IOException {
        logger.info("Start to dump cluster[{}] on binlog server[{}].", cluster, binlogServer);

        ComBinlogDumpPacket dumpBinlogPacket = (ComBinlogDumpPacket) PacketFactory.createCommandPacket(
                PacketType.COM_BINLOG_DUMP_PACKET, context);
        dumpBinlogPacket.setBinlogFileName(binlogCursor.getBinlogFileName());
        dumpBinlogPacket.setBinlogFlag(0);
        dumpBinlogPacket.setBinlogPosition(binlogCursor.getBinlogPosition());
        dumpBinlogPacket.setServerId(binlogCursor.getServerId());
        dumpBinlogPacket.buildPacket(context);
        dumpBinlogPacket.write(outputStream, context);

        OKErrorPacket okErrorPacket = (OKErrorPacket) PacketFactory.parsePacket(inputStream,
                PacketType.OKERROR_PACKET, context);

        if (!okErrorPacket.isOk()) {
            throw new BinlogDumpException(okErrorPacket.getMessage());
        }

        logger.info("Success to dump cluster[{}] on binlog server[{}].", cluster, binlogServer);
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public void setDatabases(Set<String> databases) {
        this.databases = databases;
    }

    public void setBinlogServer(BinlogServer binlogServer) {
        this.binlogServer = binlogServer;
    }

    public void setBinlogCursor(BinlogCursor binlogCursor) {
        this.binlogCursor = binlogCursor;
    }

    public void setConnectTimeoutInSecond(long connectTimeoutInSecond) {
        this.connectTimeoutInSecond = connectTimeoutInSecond;
    }
}
