package com.dianping.puma.manage.registry;

import com.dianping.puma.common.AbstractPumaLifeCycle;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public abstract class AbstractInstanceRegistry extends AbstractPumaLifeCycle implements InstanceRegistry {

    private String host;

    private int port;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    protected String generateAddress() {
        return host + ":" + port;
    }
}
