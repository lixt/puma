package com.dianping.puma.filter;

import com.dianping.puma.common.model.BinlogEvent;
import com.dianping.puma.filter.exception.PumaFilterException;

import java.util.regex.Pattern;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public class DatabaseWhiteRegexFilter extends AbstractPumaFilter {

    private String blackRegex;

    @Override
    public boolean filter(BinlogEvent binlogEvent) throws PumaFilterException {
        String database = binlogEvent.getDatabase();
        return !Pattern.matches(blackRegex, database);
    }

    public void setBlackRegex(String blackRegex) {
        this.blackRegex = blackRegex;
    }
}
