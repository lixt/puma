package com.dianping.puma.manage.core;

import com.dianping.puma.common.AbstractPumaLifeCycle;
import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.manage.core.exception.PumaManageException;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class InstanceManagerImpl extends AbstractPumaLifeCycle implements InstanceManager {

    @Override
    public void load(InstanceConfig instanceConfig) throws PumaManageException {

    }


    protected void load0(InstanceConfig instanceConfig) throws PumaManageException {

    }

    @Override
    public void unload(String database) throws PumaManageException {

    }

    @Override
    public void reload(InstanceConfig instanceConfig) throws PumaManageException {

    }
}
