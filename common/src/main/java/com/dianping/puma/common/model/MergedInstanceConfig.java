package com.dianping.puma.common.model;

import java.util.Set;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class MergedInstanceConfig {

    private String cluster;

    private Set<String> databases;

    private BinlogIndex binlogCursor;

    private Set<SQLServer> binlogServers;

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public Set<String> getDatabases() {
        return databases;
    }

    public void setDatabases(Set<String> databases) {
        this.databases = databases;
    }

    public BinlogIndex getBinlogCursor() {
        return binlogCursor;
    }

    public void setBinlogCursor(BinlogIndex binlogCursor) {
        this.binlogCursor = binlogCursor;
    }

    public Set<SQLServer> getBinlogServers() {
        return binlogServers;
    }

    public void setBinlogServers(Set<SQLServer> binlogServers) {
        this.binlogServers = binlogServers;
    }
}
