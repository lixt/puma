package com.dianping.puma.manage.monitor;

import com.dianping.puma.common.AbstractPumaLifeCycle;
import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.manage.monitor.exception.MonitorException;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.MapMaker;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class MemoryInstanceConfigMonitor extends AbstractPumaLifeCycle implements InstanceConfigMonitor {

    private ConcurrentMap<String, InstanceConfig> instanceConfigMap = new MapMaker().makeMap();

    @Override
    public InstanceConfig get(String database) throws MonitorException {
        return instanceConfigMap.get(database);
    }

    @Override
    public List<InstanceConfig> getAll() throws MonitorException {
        return FluentIterable.from(instanceConfigMap.values()).toList();
    }

    public void set(String database, InstanceConfig instanceConfig) throws MonitorException {
    }
}
