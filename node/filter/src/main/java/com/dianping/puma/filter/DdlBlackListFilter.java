package com.dianping.puma.filter;

import com.dianping.puma.common.constant.DDL;
import com.dianping.puma.common.model.PumaEvent;
import com.dianping.puma.common.model.DdlPumaEvent;
import com.dianping.puma.filter.exception.PumaFilterException;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public class DdlBlackListFilter extends AbstractPumaFilter {

    private List<DDL> blackList;

    @Override
    public boolean filter(PumaEvent binlogEvent) throws PumaFilterException {
        if (!(binlogEvent instanceof DdlPumaEvent)) {
            return true;
        }

        DDL ddl = ((DdlPumaEvent) binlogEvent).getDdl();
        return !blackList.contains(ddl);
    }

    public void setBlackList(List<DDL> blackList) {
        this.blackList = blackList;
    }
}
