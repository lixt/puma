package com.dianping.puma.common.constant;

/**
 * Created by xiaotian.li on 16/2/16.
 * Email: lixiaotian07@gmail.com
 */
public enum Manipulation {

    SELECT,

    INSERT,

    UPDATE,

    DELETE;

    public boolean isSelect() {
        return this.equals(SELECT);
    }

    public boolean isInsert() {
        return this.equals(INSERT);
    }

    public boolean isUpdate() {
        return this.equals(UPDATE);
    }

    public boolean isDelete() {
        return this.equals(DELETE);
    }
}
