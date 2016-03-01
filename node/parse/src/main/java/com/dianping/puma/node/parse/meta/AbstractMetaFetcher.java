package com.dianping.puma.node.parse.meta;

import com.dianping.puma.common.AbstractPumaLifeCycle;

/**
 * Created by xiaotian.li on 16/2/26.
 * Email: lixiaotian07@gmail.com
 */
public abstract class AbstractMetaFetcher extends AbstractPumaLifeCycle implements MetaFetcher {

    @Override
    public void start() {
        super.start();

        connect();
    }

    @Override
    public void stop() {
        super.stop();

        close();
    }

    protected abstract void connect();

    protected abstract void close();
}
