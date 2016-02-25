package com.dianping.puma.filter;

import com.dianping.puma.common.model.BinlogEvent;
import com.dianping.puma.filter.exception.PumaFilterException;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public class TableBlackListFilter extends AbstractPumaFilter {

    private List<String> blackList;

    @Override
    public boolean filter(BinlogEvent binlogEvent) throws PumaFilterException {
        String table = binlogEvent.getTable();
        return !blackList.contains(table);
    }

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }
}
