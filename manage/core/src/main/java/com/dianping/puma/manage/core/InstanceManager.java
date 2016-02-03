package com.dianping.puma.manage.core;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.manage.core.exception.ManageException;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public interface InstanceManager extends PumaLifeCycle {

    void load(InstanceConfig instanceConfig) throws ManageException;

    void unload(String database) throws ManageException;

    void reload(InstanceConfig instanceConfig) throws ManageException;
}
