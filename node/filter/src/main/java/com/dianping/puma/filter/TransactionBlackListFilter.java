package com.dianping.puma.filter;

import com.dianping.puma.common.constant.Transaction;
import com.dianping.puma.common.model.PumaEvent;
import com.dianping.puma.common.model.TransactionPumaEvent;
import com.dianping.puma.filter.exception.PumaFilterException;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/16.
 * Email: lixiaotian07@gmail.com
 */
public class TransactionBlackListFilter extends AbstractPumaFilter {

    // Default filter out no transaction events.
    private List<Transaction> blackList = Lists.newArrayList();

    @Override
    public boolean filter(PumaEvent binlogEvent) throws PumaFilterException {
        if (!(binlogEvent instanceof TransactionPumaEvent)) {
            return true;
        }

        Transaction transaction = ((TransactionPumaEvent) binlogEvent).getTransaction();
        return !blackList.contains(transaction);
    }

    public void setBlackList(List<Transaction> blackList) {
        this.blackList = blackList;
    }
}
