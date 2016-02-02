package com.dianping.puma.manage.core;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.manage.core.exception.PumaManageException;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public interface PumaManager extends PumaLifeCycle {

    void start() throws PumaManageException;

    void stop() throws PumaManageException;
}
