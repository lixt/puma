package com.dianping.puma.test;

import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.common.model.InstanceStatus;
import com.dianping.puma.manage.monitor.MemoryInstanceConfigMonitor;
import com.dianping.puma.server.AbstractPumaServer;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class TestingPumaServer extends AbstractPumaServer {

    private MemoryInstanceConfigMonitor instanceConfigMonitor;

    public TestingPumaServer() {
        init();
    }

    private void init() {
        instanceConfigMonitor = new MemoryInstanceConfigMonitor();
    }

    public void setInstanceConfig(String database, InstanceConfig instanceConfig) {

    }

    public void removeInstanceConfig(String database) {

    }

    public InstanceStatus getInstanceStatus(String database) {
        return null;
    }
}
