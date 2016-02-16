package com.dianping.puma.filter;

import com.dianping.puma.common.constant.Transaction;
import com.dianping.puma.common.model.BinlogEvent;
import com.dianping.puma.common.model.TransactionBinlogEvent;
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
    public boolean filter(BinlogEvent binlogEvent) throws PumaFilterException {
        if (!(binlogEvent instanceof TransactionBinlogEvent)) {
            return true;
        }

        Transaction transaction = ((TransactionBinlogEvent) binlogEvent).getTransaction();
        return !blackList.contains(transaction);
    }

    public void setBlackList(List<Transaction> blackList) {
        this.blackList = blackList;
    }
}
