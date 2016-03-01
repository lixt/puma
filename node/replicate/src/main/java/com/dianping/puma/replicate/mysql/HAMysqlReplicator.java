package com.dianping.puma.replicate.mysql;

import com.dianping.puma.common.model.SQLServer;
import com.dianping.puma.replicate.AbstractPumaReplicator;
import com.dianping.puma.replicate.exception.PumaReplicateException;

import java.nio.ByteBuffer;
import java.util.List;

/**
 * Created by xiaotian.li on 16/2/19.
 * Email: lixiaotian07@gmail.com
 */
public class HAMysqlReplicator extends AbstractPumaReplicator {

    private List<SQLServer> binlogServers;



    @Override
    public ByteBuffer replicate() throws PumaReplicateException {
        return null;
    }
}
