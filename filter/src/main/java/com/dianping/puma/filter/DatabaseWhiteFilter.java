package com.dianping.puma.filter;

import com.dianping.puma.common.model.BinlogEvent;
import com.dianping.puma.filter.exception.PumaFilterException;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public class DatabaseWhiteFilter extends AbstractPumaFilter {

    private List<String> whiteList = Lists.newArrayList();

    @Override
    public boolean filter(BinlogEvent binlogEvent) throws PumaFilterException {
        String database = binlogEvent.getDatabase();
        return whiteList.contains(database);
    }

    public void setWhiteList(List<String> whiteList) {
        this.whiteList = whiteList;
    }
}
