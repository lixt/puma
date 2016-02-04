package com.dianping.puma.test;

import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.common.model.InstanceStatus;
import com.dianping.puma.manage.monitor.MemoryInstanceConfigMonitor;
import com.dianping.puma.server.PumaServerWithoutSpring;
import com.dianping.puma.test.config.TestingPumaConfig;
import com.dianping.puma.test.exception.PumaUnsupportedOperationException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class TestingPumaServer extends PumaServerWithoutSpring {

    public TestingPumaServer() {
        super(new TestingPumaConfig());
    }

    public void setInstanceConfig(String database, InstanceConfig instanceConfig) {
        if (!(monitor instanceof MemoryInstanceConfigMonitor)) {
            throw new PumaUnsupportedOperationException("Operation only support memory mode monitor.");
        }

        ((MemoryInstanceConfigMonitor) monitor).set(database, instanceConfig);
    }

    public void removeInstanceConfig(String database) {
        if (!(monitor instanceof MemoryInstanceConfigMonitor)) {
            throw new PumaUnsupportedOperationException("Operation only support memory mode monitor.");
        }

        ((MemoryInstanceConfigMonitor) monitor).remove(database);
    }

    public InstanceStatus getInstanceStatus(String database) {
        return null;
    }
}
