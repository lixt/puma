package com.dianping.puma.filter;

import com.dianping.puma.common.model.PumaEvent;
import com.dianping.puma.filter.exception.PumaFilterException;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public class ChainedFilter extends AbstractPumaFilter {

    private List<PumaFilter> pumaFilters = Lists.newArrayList();

    @Override
    public boolean filter(final PumaEvent binlogEvent) throws PumaFilterException {
        return FluentIterable
                .from(pumaFilters)
                .allMatch(new Predicate<PumaFilter>() {
                    @Override
                    public boolean apply(PumaFilter pumaFilter) {
                        return pumaFilter.filter(binlogEvent);
                    }
                });
    }

    public void setPumaFilters(List<PumaFilter> pumaFilters) {
        this.pumaFilters = pumaFilters;
    }
}
