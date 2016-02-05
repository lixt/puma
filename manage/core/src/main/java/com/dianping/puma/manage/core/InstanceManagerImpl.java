package com.dianping.puma.manage.core;

import com.dianping.puma.common.AbstractPumaLifeCycle;
import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.common.model.MergedInstanceConfig;
import com.dianping.puma.manage.core.exception.PumaManageException;
import com.dianping.puma.manage.core.merge.MergedInstanceManager;
import com.dianping.puma.manage.merge.InstanceConfigMerger;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class InstanceManagerImpl extends AbstractPumaLifeCycle implements InstanceManager {

    private InstanceConfigMerger instanceConfigMerger;

    private MergedInstanceManager mergedInstanceManager;

    @Override
    public void load(InstanceConfig instanceConfig) throws PumaManageException {
        load0(instanceConfig);
    }


    protected void load0(InstanceConfig instanceConfig) {
        MergedInstanceConfig mergedInstanceConfig = instanceConfigMerger.merge(instanceConfig);
        //mergedInstanceManager.load(mergedInstanceConfig);
        System.out.println("hello world.");
    }

    @Override
    public void unload(String database) throws PumaManageException {

    }

    @Override
    public void reload(InstanceConfig instanceConfig) throws PumaManageException {

    }

    public void setInstanceConfigMerger(InstanceConfigMerger instanceConfigMerger) {
        this.instanceConfigMerger = instanceConfigMerger;
    }

    public void setMergedInstanceManager(MergedInstanceManager mergedInstanceManager) {
        this.mergedInstanceManager = mergedInstanceManager;
    }
}
