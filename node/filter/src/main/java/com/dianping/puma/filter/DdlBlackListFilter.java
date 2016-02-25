package com.dianping.puma.filter;

import com.dianping.puma.common.constant.DDL;
import com.dianping.puma.common.model.BinlogEvent;
import com.dianping.puma.common.model.DdlBinlogEvent;
import com.dianping.puma.filter.exception.PumaFilterException;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public class DdlBlackListFilter extends AbstractPumaFilter {

    private List<DDL> blackList;

    @Override
    public boolean filter(BinlogEvent binlogEvent) throws PumaFilterException {
        if (!(binlogEvent instanceof DdlBinlogEvent)) {
            return true;
        }

        DDL ddl = ((DdlBinlogEvent) binlogEvent).getDdl();
        return !blackList.contains(ddl);
    }

    public void setBlackList(List<DDL> blackList) {
        this.blackList = blackList;
    }
}
