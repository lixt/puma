package com.dianping.puma.common.model;

import com.dianping.puma.common.constant.Transaction;

/**
 * Created by xiaotian.li on 16/2/16.
 * Email: lixiaotian07@gmail.com
 */
public class TransactionPumaEvent extends PumaEvent {

    private Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
