package com.dianping.puma.common.model;

import java.util.Set;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public class InstanceConfig {

    private String database;

    private String tableBlackRegex;

    private BinlogCursor binlogCursor;

    private Set<BinlogServer> binlogServers;

    private boolean mergable;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public BinlogCursor getBinlogCursor() {
        return binlogCursor;
    }

    public void setBinlogCursor(BinlogCursor binlogCursor) {
        this.binlogCursor = binlogCursor;
    }

    public Set<BinlogServer> getBinlogServers() {
        return binlogServers;
    }

    public void setBinlogServers(Set<BinlogServer> binlogServers) {
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
