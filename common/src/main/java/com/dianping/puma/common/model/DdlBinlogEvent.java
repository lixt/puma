package com.dianping.puma.common.model;

import com.dianping.puma.common.constant.DDL;

/**
 * Created by xiaotian.li on 16/2/16.
 * Email: lixiaotian07@gmail.com
 */
public class DdlBinlogEvent extends BinlogEvent {

    private DDL ddl;

    public DDL getDdl() {
        return ddl;
    }

    public void setDdl(DDL ddl) {
        this.ddl = ddl;
    }
}
