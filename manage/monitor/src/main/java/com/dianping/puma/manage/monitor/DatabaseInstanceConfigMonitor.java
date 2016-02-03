package com.dianping.puma.manage.monitor;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.instance.core.config.InstanceConfig;
import com.dianping.puma.manage.monitor.exception.MonitorException;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public interface DatabaseInstanceConfigMonitor extends PumaLifeCycle {

    InstanceConfig getInstanceConfig(String database) throws MonitorException;

    List<InstanceConfig> getAllInstanceConfigs() throws MonitorException;
}
