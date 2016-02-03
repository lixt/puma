package com.dianping.puma.manage.monitor.react;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.manage.monitor.exception.ReactException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public interface InstanceConfigReactor {

    void onCreated(InstanceConfig instanceConfig) throws ReactException;

    void onUpdated(InstanceConfig instanceConfig, InstanceConfig oriInstanceConfig) throws ReactException;

    void onDeleted(InstanceConfig oriInstanceConfig) throws ReactException;
}
