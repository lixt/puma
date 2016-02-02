package com.dianping.puma.instance.core.model;

import com.dianping.puma.core.model.BinlogInfo;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public class DatabaseConfig {

    private int id;

    private String databaseName;

    private String tableBlackRegex;

    private List<BinlogInfo> binlogInfos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableBlackRegex() {
        return tableBlackRegex;
    }

    public void setTableBlackRegex(String tableBlackRegex) {
        this.tableBlackRegex = tableBlackRegex;
    }

    public List<BinlogInfo> getBinlogInfos() {
        return binlogInfos;
    }

    public void setBinlogInfos(List<BinlogInfo> binlogInfos) {
        this.binlogInfos = binlogInfos;
    }
}
