package com.dianping.puma.manage.monitor;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.manage.monitor.exception.PumaMonitorException;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public interface PumaMonitor extends PumaLifeCycle {

    void start() throws PumaMonitorException;

    void stop() throws PumaMonitorException;
}
