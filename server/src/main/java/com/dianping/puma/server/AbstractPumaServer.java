package com.dianping.puma.server;

import com.dianping.puma.common.AbstractPumaLifeCycle;
import com.dianping.puma.manage.core.InstanceManager;
import com.dianping.puma.manage.monitor.InstanceConfigMonitor;
import com.dianping.puma.manage.record.InstanceStatusRecorder;
import com.dianping.puma.server.exception.PumaServerException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public abstract class AbstractPumaServer extends AbstractPumaLifeCycle implements PumaServer {

    private InstanceManager instanceManager;

    private InstanceConfigMonitor instanceConfigMonitor;

    private InstanceStatusRecorder instanceStatusRecorder;

    @Override
    public void start() {
        super.start();

        try {
            instanceManager.start();
            instanceConfigMonitor.start();
            instanceStatusRecorder.start();
        } catch (Throwable t) {
            throw new PumaServerException("Failed to start puma server.", t);
        }
    }

    @Override
    public void stop() {
        super.stop();

        try {
            instanceManager.stop();
            instanceConfigMonitor.stop();
            instanceStatusRecorder.stop();
        } catch (Throwable t) {
            throw new PumaServerException("Failed to stop puma server.", t);
        }
    }
}
