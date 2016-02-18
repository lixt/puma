package com.dianping.puma.replicate.mysql;

import com.dianping.puma.common.model.BinlogCursor;
import com.dianping.puma.common.model.BinlogServer;
import com.dianping.puma.replicate.AbstractPumaReplicator;
import com.dianping.puma.replicate.exception.PumaReplicateException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Set;

/**
 * Created by xiaotian.li on 16/2/16.
 * Email: lixiaotian07@gmail.com
 */
public class SimpleMysqlReplicator extends AbstractPumaReplicator {

    private String cluster;

    private Set<String> databases;

    private BinlogServer binlogServer;

    private BinlogCursor binlogCursor;

    private Socket socket;

    private InputStream inputStream;

    private OutputStream outputStream;

    @Override
    public ByteBuffer replicate() throws PumaReplicateException {
        return null;
    }

    private void connect() {

    }

    private void auth() {

    }

    private void setup() {

    }

    private void validate() {

    }

    private void dumpBinlog() {

    }
}
