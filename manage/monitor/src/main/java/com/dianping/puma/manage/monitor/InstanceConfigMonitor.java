package com.dianping.puma.manage.monitor;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.manage.monitor.exception.MonitorException;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public interface InstanceConfigMonitor extends PumaLifeCycle {

    InstanceConfig get(String database) throws MonitorException;

    List<InstanceConfig> getAll() throws MonitorException;
}
