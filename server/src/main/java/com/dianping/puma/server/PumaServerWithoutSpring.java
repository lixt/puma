package com.dianping.puma.server;

import com.dianping.puma.manage.core.InstanceManagerImpl;
import com.dianping.puma.manage.core.merge.MergedInstanceManager;
import com.dianping.puma.manage.merge.InstanceConfigMerger;
import com.dianping.puma.manage.merge.StrictInstanceConfigMerger;
import com.dianping.puma.manage.monitor.MemoryInstanceConfigMonitor;
import com.dianping.puma.manage.monitor.react.InstanceConfigReactorImpl;
import com.dianping.puma.server.config.PumaConfig;
import com.dianping.puma.server.config.mode.MonitorMode;
import com.dianping.puma.server.exception.PumaUnimplementedModeException;
import com.dianping.puma.server.exception.PumaUnsupportedModeException;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class PumaServerWithoutSpring extends AbstractPumaServer {

    protected PumaConfig config;

    public PumaServerWithoutSpring(PumaConfig config) {
        this.config = config;

        logger.info("Start initializing puma server...");

        init();

        logger.info("Success to initialize puma server.");
    }

    private void init() {
        initManager();
        initReactor();
        initMonitor();
    }

    private void initManager() {
        InstanceManagerImpl masterImpl = new InstanceManagerImpl();

        InstanceConfigMerger merger = new StrictInstanceConfigMerger();
        masterImpl.setInstanceConfigMerger(merger);

        manager = masterImpl;
    }

    private void initReactor() {
        InstanceConfigReactorImpl reactorImpl = new InstanceConfigReactorImpl();
        reactorImpl.setInstanceManager(manager);
        reactor = reactorImpl;
    }

    private void initMonitor() {
        MonitorMode monitorMode = config.getMonitorMode();

        switch (monitorMode) {
            case MEMORY:
                initMemoryMonitor();
                break;
            case FILE:
                throw new PumaUnimplementedModeException("monitor mode[FILE].");
            case MYSQL:
                throw new PumaUnimplementedModeException("monitor mode[MYSQL].");
            case MONGO:
                throw new PumaUnimplementedModeException("monitor mode[MONGO].");
            default:
                throw new PumaUnsupportedModeException("monitor mode[%s].", monitorMode);
        }
    }

    private void initMemoryMonitor() {
        MemoryInstanceConfigMonitor memoryInstanceConfigMonitor = new MemoryInstanceConfigMonitor();
        memoryInstanceConfigMonitor.setScanIntervalInSecond(config.getMonitorScanIntervalInSecond());
        memoryInstanceConfigMonitor.setInstanceConfigReactor(reactor);
        monitor = memoryInstanceConfigMonitor;
    }
}
