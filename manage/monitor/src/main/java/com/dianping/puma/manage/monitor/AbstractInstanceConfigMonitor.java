package com.dianping.puma.manage.monitor;

import com.dianping.puma.common.AbstractPumaLifeCycle;
import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.common.util.NamedThreadFactory;
import com.dianping.puma.manage.monitor.exception.MonitorException;
import com.dianping.puma.manage.monitor.react.InstanceConfigReactor;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public abstract class AbstractInstanceConfigMonitor extends AbstractPumaLifeCycle implements InstanceConfigMonitor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private long scanIntervalInSecond = 5;

    private List<InstanceConfig> instanceConfigsCached = Lists.newArrayList();

    private InstanceConfigReactor instanceConfigReactor;

    private ScheduledExecutorService scanner
            = Executors.newScheduledThreadPool(1, new NamedThreadFactory(getClass() + "-scanner"));

    @Override
    public void start() {
        super.start();

        try {
            scanner.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    try {
                        scan();
                    } catch (MonitorException e) {
                        logger.error("Failed to periodically scan puma instance configs.", e);
                    }
                }
            }, 0, scanIntervalInSecond, TimeUnit.SECONDS);
        } catch (Throwable t) {
            throw new MonitorException("Failed to start scanner.", t);
        }
    }

    @Override
    public void stop() {
        super.stop();

        try {
            scanner.shutdownNow();
        } catch (Throwable t) {
            throw new MonitorException("Failed to stop scanner.", t);
        }
    }

    private void scan() throws MonitorException {
        try {
            List<InstanceConfig> instanceConfigs = getAll();

            handleDeletedInstanceConfig(instanceConfigs, instanceConfigsCached);
            handleCreatedInstanceConfig(instanceConfigs, instanceConfigsCached);
            handleUpdatedInstanceConfig(instanceConfigs, instanceConfigsCached);

            instanceConfigsCached = instanceConfigs;

        } catch (Throwable t) {
            throw new MonitorException("Failed to scan puma instance configs.", t);
        }
    }

    private List<InstanceConfig> handleCreatedInstanceConfig(
            List<InstanceConfig> instanceConfigs, List<InstanceConfig> instanceConfigsCached) {
        return null;
    }

    private List<InstanceConfig> handleUpdatedInstanceConfig(
            List<InstanceConfig> instanceConfigs, List<InstanceConfig> instanceConfigsCached) {
        return null;
    }

    private List<InstanceConfig> handleDeletedInstanceConfig(
            List<InstanceConfig> instanceConfigs, List<InstanceConfig> instanceConfigsCached) {
        return null;
    }
}
