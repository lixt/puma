package com.dianping.puma.manage.reactor;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.manage.reactor.exception.ReactorException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public interface InstanceConfigReactor extends PumaLifeCycle {

    void onCreated(InstanceConfig instanceConfig) throws ReactorException;

    void onUpdated(InstanceConfig instanceConfig, InstanceConfig oriInstanceConfig) throws ReactorException;

    void onDeleted(InstanceConfig oriInstanceConfig) throws ReactorException;
}
