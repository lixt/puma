package com.dianping.puma.filter;

import com.dianping.puma.common.constant.Transaction;
import com.dianping.puma.common.model.BinlogEvent;
import com.dianping.puma.common.model.TransactionBinlogEvent;
import com.dianping.puma.filter.exception.PumaFilterException;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public class TransactionWhiteListFilter extends AbstractPumaFilter {

    // Default filter out all transaction events.
    private List<Transaction> whiteList = Lists.newArrayList();

    @Override
    public boolean filter(BinlogEvent binlogEvent) throws PumaFilterException {
        if (!(binlogEvent instanceof TransactionBinlogEvent)) {
            return true;
        }

        Transaction transaction = ((TransactionBinlogEvent) binlogEvent).getTransaction();
        return whiteList.contains(transaction);
    }

    public void setWhiteList(List<Transaction> whiteList) {
        this.whiteList = whiteList;
    }
}
