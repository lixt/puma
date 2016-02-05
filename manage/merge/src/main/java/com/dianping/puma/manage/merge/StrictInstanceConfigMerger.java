package com.dianping.puma.manage.merge;

import com.dianping.puma.common.model.BinlogServer;

import java.util.Set;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class StrictInstanceConfigMerger extends AbstractInstanceConfigMerger {

    @Override
    protected Set<BinlogServer> mergeBinlogServers(Set<BinlogServer> mergedBinlogServers,
                                                   Set<BinlogServer> binlogServers) {
        return null;
    }
}
