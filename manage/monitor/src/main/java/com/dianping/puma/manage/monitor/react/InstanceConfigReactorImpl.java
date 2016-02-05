package com.dianping.puma.manage.monitor.react;

import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.manage.core.InstanceManager;
import com.dianping.puma.manage.core.exception.PumaManageException;
import com.dianping.puma.manage.monitor.exception.ReactException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class InstanceConfigReactorImpl implements InstanceConfigReactor {

    private InstanceManager instanceManager;

    @Override
    public void onCreated(InstanceConfig instanceConfig) throws ReactException {
        try {
            instanceManager.load(instanceConfig);
        } catch (PumaManageException e) {
            throw new ReactException("Failed to react to instance config[%s].", instanceConfig);
        }
    }

    @Override
    public void onUpdated(InstanceConfig instanceConfig, InstanceConfig oriInstanceConfig) throws ReactException {
        System.out.println("updated");
    }

    @Override
    public void onDeleted(InstanceConfig oriInstanceConfig) throws ReactException {
        System.out.println("deleted");
    }

    public void setInstanceManager(InstanceManager instanceManager) {
        this.instanceManager = instanceManager;
    }
}
