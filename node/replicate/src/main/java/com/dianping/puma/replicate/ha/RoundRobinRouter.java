package com.dianping.puma.replicate.ha;

import com.dianping.puma.common.model.BinlogServer;

/**
 * Created by xiaotian.li on 16/2/21.
 * Email: lixiaotian07@gmail.com
 */
public class RoundRobinRouter extends AbstractBinlogRouter {

    private int index;

    @Override
    public BinlogServer next() {
        int total = binlogServers.size();
        if (index > total - 1) {
            index -= total;
        }
        return binlogServers.get(index++);
    }
}
