package com.dianping.puma.manage.registry;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.manage.registry.exception.PumaInstanceRegistryException;

/**
 * Created by xiaotian.li on 16/2/5.
 * Email: lixiaotian07@gmail.com
 */
public interface InstanceRegistry extends PumaLifeCycle {

    void register(String database) throws PumaInstanceRegistryException;

    void unregister(String database) throws PumaInstanceRegistryException;
}
