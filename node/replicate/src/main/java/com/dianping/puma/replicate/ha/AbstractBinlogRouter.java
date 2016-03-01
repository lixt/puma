package com.dianping.puma.replicate.ha;

import com.dianping.puma.common.AbstractPumaLifeCycle;
import com.dianping.puma.common.model.SQLServer;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/21.
 * Email: lixiaotian07@gmail.com
 */
public abstract class AbstractBinlogRouter extends AbstractPumaLifeCycle implements BinlogRouter {

    protected List<SQLServer> binlogServers;

    @Override
    public SQLServer getByServerId(final Long serverId) {
        Optional<SQLServer> optional = FluentIterable
                .from(binlogServers)
                .firstMatch(new Predicate<SQLServer>() {
                    @Override
                    public boolean apply(SQLServer binlogServer) {
                        return serverId.equals(binlogServer.getServerId());
                    }
                });
        return optional.isPresent() ? optional.get() : null;
    }

    public void setBinlogServers(List<SQLServer> binlogServers) {
        this.binlogServers = binlogServers;
    }
}
