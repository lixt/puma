package com.dianping.puma.instance.core.model;

import com.dianping.puma.core.model.BinlogInfo;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public class DbTask {

    private int id;

    private String database;

    private String tableBlackRegex;

    private List<BinlogInfo> binlogInfos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
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
