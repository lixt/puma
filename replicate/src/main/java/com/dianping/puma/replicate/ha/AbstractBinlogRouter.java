package com.dianping.puma.replicate.ha;

import com.dianping.puma.common.AbstractPumaLifeCycle;
import com.dianping.puma.common.model.BinlogServer;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/21.
 * Email: lixiaotian07@gmail.com
 */
public abstract class AbstractBinlogRouter extends AbstractPumaLifeCycle implements BinlogRouter {

    protected List<BinlogServer> binlogServers;

    @Override
    public BinlogServer getByServerId(final Long serverId) {
        Optional<BinlogServer> optional = FluentIterable
                .from(binlogServers)
                .firstMatch(new Predicate<BinlogServer>() {
                    @Override
                    public boolean apply(BinlogServer binlogServer) {
                        return serverId.equals(binlogServer.getServerId());
                    }
                });
        return optional.isPresent() ? optional.get() : null;
    }

    public void setBinlogServers(List<BinlogServer> binlogServers) {
        this.binlogServers = binlogServers;
    }
}
