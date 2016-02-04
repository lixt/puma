package com.dianping.puma.test;

import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.common.model.InstanceStatus;
import com.dianping.puma.server.PumaServerWithoutSpring;
import com.dianping.puma.test.running.TestingPumaConfig;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class TestingPumaServer extends PumaServerWithoutSpring {

    public TestingPumaServer() {
        super(new TestingPumaConfig());
    }

    public void setInstanceConfig(String database, InstanceConfig instanceConfig) {

    }

    public void removeInstanceConfig(String database) {

    }

    public InstanceStatus getInstanceStatus(String database) {
        return null;
    }
}
