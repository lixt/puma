package com.dianping.puma.server;

import com.dianping.puma.common.AbstractPumaLifeCycle;
import com.dianping.puma.manage.core.InstanceManager;
import com.dianping.puma.manage.monitor.InstanceConfigMonitor;
import com.dianping.puma.manage.monitor.react.InstanceConfigReactor;
import com.dianping.puma.manage.record.InstanceStatusRecorder;
import com.dianping.puma.server.exception.PumaServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public abstract class AbstractPumaServer extends AbstractPumaLifeCycle implements PumaServer {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected InstanceManager instanceManager;

    protected InstanceConfigMonitor monitor;

    protected InstanceConfigReactor reactor;

    protected InstanceStatusRecorder recorder;

    @Override
    public void start() {
        super.start();

        try {
            monitor.start();
        } catch (Throwable t) {
            throw new PumaServerException("Failed to start puma server.", t);
        }
    }

    @Override
    public void stop() {
        super.stop();

        try {
            monitor.stop();
            recorder.stop();
        } catch (Throwable t) {
            throw new PumaServerException("Failed to stop puma server.", t);
        }
    }
}
