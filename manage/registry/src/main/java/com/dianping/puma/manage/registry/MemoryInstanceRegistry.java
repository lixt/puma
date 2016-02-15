package com.dianping.puma.manage.registry;

import com.dianping.puma.manage.registry.exception.PumaInstanceRegistryException;
import com.google.common.collect.Sets;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public class MemoryInstanceRegistry extends AbstractInstanceRegistry {

    private ConcurrentMap<String, Set<String>> registry = new ConcurrentHashMap<String, Set<String>>();

    @Override
    public void register(String database) throws PumaInstanceRegistryException {
        Set<String> addresses = registry.get(database);
        if (addresses == null) {
            addresses = Sets.newHashSet();
        }
        addresses.add(generateAddress());
        registry.put(database, addresses);
    }

    @Override
    public void unregister(String database) throws PumaInstanceRegistryException {
        Set<String> addresses = registry.get(database);
        if (addresses != null) {
            addresses.remove(generateAddress());
            registry.put(database, addresses);
        }
    }
}
