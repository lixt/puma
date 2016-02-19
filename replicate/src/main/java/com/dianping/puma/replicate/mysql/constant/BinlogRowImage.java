package com.dianping.puma.replicate.mysql.constant;

/**
 * Created by xiaotian.li on 16/2/19.
 * Email: lixiaotian07@gmail.com
 */
public enum BinlogRowImage {

    FULL,

    MINIMAL,

    NOBLOB;

    public boolean isFull() {
        return this.equals(FULL);
    }

    public boolean isMinimal() {
        return this.equals(MINIMAL);
    }

    public boolean isNoBlob() {
        return this.equals(NOBLOB);
    }
}
