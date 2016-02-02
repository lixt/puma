package com.dianping.puma.manage.monitor.db;

import com.dianping.puma.common.AbstractPumaLifeCycle;
import com.dianping.puma.common.util.NamedThreadFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public abstract class AbstractDbTaskMonitor extends AbstractPumaLifeCycle implements DbTaskMonitor {

    private long scanIntervalInSecond = 5;

    private ScheduledExecutorService scanner
            = Executors.newScheduledThreadPool(1, new NamedThreadFactory("db-task-monitor"));

    public void setScanIntervalInSecond(long scanIntervalInSecond) {
        this.scanIntervalInSecond = scanIntervalInSecond;
    }
}
