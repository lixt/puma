package com.dianping.puma.manage.merge;

import com.dianping.puma.common.model.SQLServer;

import java.util.Set;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class StrictInstanceConfigMerger extends AbstractInstanceConfigMerger {

    @Override
    protected Set<SQLServer> mergeBinlogServers(Set<SQLServer> mergedBinlogServers,
                                                Set<SQLServer> binlogServers) {
        return null;
    }
}
