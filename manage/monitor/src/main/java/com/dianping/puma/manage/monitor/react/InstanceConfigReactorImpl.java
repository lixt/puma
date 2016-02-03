package com.dianping.puma.manage.monitor.react;

import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.manage.monitor.exception.ReactException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class InstanceConfigReactorImpl implements InstanceConfigReactor {

    @Override
    public void onCreated(InstanceConfig instanceConfig) throws ReactException {
        System.out.println("created");
    }

    @Override
    public void onUpdated(InstanceConfig instanceConfig, InstanceConfig oriInstanceConfig) throws ReactException {
        System.out.println("updated");
    }

    @Override
    public void onDeleted(InstanceConfig oriInstanceConfig) throws ReactException {
        System.out.println("deleted");
    }
}
