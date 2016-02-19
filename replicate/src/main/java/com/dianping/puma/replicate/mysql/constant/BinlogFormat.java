package com.dianping.puma.replicate.mysql.constant;

/**
 * Created by xiaotian.li on 16/2/19.
 * Email: lixiaotian07@gmail.com
 */
public enum BinlogFormat {

    STATEMENT,

    ROW,

    MIXED;

    public boolean isStatement() {
        return this.equals(STATEMENT);
    }

    public boolean isRow() {
        return this.equals(ROW);
    }

    public boolean isMixed() {
        return this.equals(MIXED);
    }
}
