package com.dianping.puma.replicate;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.common.mysql.packet.BinlogPacket;
import com.dianping.puma.replicate.exception.PumaReplicateException;

import java.nio.ByteBuffer;

/**
 * Created by xiaotian.li on 16/2/16.
 * Email: lixiaotian07@gmail.com
 */
public interface PumaReplicator extends PumaLifeCycle {

    ByteBuffer replicate() throws PumaReplicateException;
}
