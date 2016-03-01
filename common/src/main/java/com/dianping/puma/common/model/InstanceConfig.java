package com.dianping.puma.common.model;

import java.util.Set;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public class InstanceConfig {

    private String cluster;

    private String database;

    private String tableBlackRegex;

    private BinlogIndex binlogCursor;

    private Set<SQLServer> binlogServers;

    private boolean mergable;

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
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

    public String getTableBlackRegex() {
        return tableBlackRegex;
    }

    public void setTableBlackRegex(String tableBlackRegex) {
        this.tableBlackRegex = tableBlackRegex;
    }

    public boolean isMergable() {
        return mergable;
    }

    public void setMergable(boolean mergable) {
        this.mergable = mergable;
    }
}
