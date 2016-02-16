package com.dianping.puma.common.constant;

/**
 * Created by xiaotian.li on 16/2/16.
 * Email: lixiaotian07@gmail.com
 */
public enum Transaction {

    BEGIN,

    COMMIT;

    public boolean isBegin() {
        return this.equals(BEGIN);
    }

    public boolean isCommit() {
        return this.equals(COMMIT);
    }
}
