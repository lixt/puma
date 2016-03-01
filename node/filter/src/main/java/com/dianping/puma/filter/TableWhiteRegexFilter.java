package com.dianping.puma.filter;

import com.dianping.puma.common.model.PumaEvent;
import com.dianping.puma.filter.exception.PumaFilterException;

import java.util.regex.Pattern;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public class TableWhiteRegexFilter extends AbstractPumaFilter {

    private String whiteRegex;

    @Override
    public boolean filter(PumaEvent binlogEvent) throws PumaFilterException {
        String table = binlogEvent.getTable();
        return Pattern.matches(whiteRegex, table);
    }

    public void setWhiteRegex(String whiteRegex) {
        this.whiteRegex = whiteRegex;
    }
}
