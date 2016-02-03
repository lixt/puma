package com.dianping.puma.server;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.server.exception.PumaServerException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public interface PumaServer extends PumaLifeCycle {

    void start() throws PumaServerException;

    void stop() throws PumaServerException;
}
