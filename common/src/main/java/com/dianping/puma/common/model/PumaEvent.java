package com.dianping.puma.common.model;

import java.io.Serializable;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public class PumaEvent implements Serializable {

    private static final long serialVersionUID = 7986284681273254506L;

    protected String database;

    protected String table;

    protected BinlogIndex binlogCursor;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public BinlogIndex getBinlogCursor() {
        return binlogCursor;
    }

    public void setBinlogCursor(BinlogIndex binlogCursor) {
        this.binlogCursor = binlogCursor;
    }
}
