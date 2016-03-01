package com.dianping.puma.filter;

import com.dianping.puma.common.model.PumaEvent;
import com.dianping.puma.filter.exception.PumaFilterException;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public class TableWhiteListFilter extends AbstractPumaFilter {

    private List<String> whiteList;

    @Override
    public boolean filter(PumaEvent binlogEvent) throws PumaFilterException {
        String table = binlogEvent.getTable();
        return whiteList.contains(table);
    }

    public void setWhiteList(List<String> whiteList) {
        this.whiteList = whiteList;
    }
}
