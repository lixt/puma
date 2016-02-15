package com.dianping.puma.manage.monitor.support;

import com.dianping.puma.common.model.BinlogServer;

import java.util.Set;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public interface DatabaseClusterReader {

    String getCluster(String database);

    Set<BinlogServer> getServers(String cluster);
}
