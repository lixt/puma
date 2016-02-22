package com.dianping.puma.replicate.mysql.packet;

import com.dianping.puma.common.mysql.packet.BinlogPacket;
import com.dianping.puma.common.mysql.packet.OKErrorPacket;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xiaotian.li on 16/2/19.
 * Email: lixiaotian07@gmail.com
 */
public class Packets {

    public static OKErrorPacket readOKErrorPacket(InputStream inputStream) throws IOException {
        return null;
    }

    public static BinlogPacket readBinlogPacket(InputStream inputStream) throws IOException {
        BinlogPacket binlogPacket = new BinlogPacket();
        binlogPacket.readPacket(inputStream, null);
        return binlogPacket;
    }
}
