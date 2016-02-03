package com.dianping.puma.manage.record;

import com.dianping.puma.common.AbstractPumaLifeCycle;
import com.dianping.puma.instance.core.status.InstanceStatus;
import com.dianping.puma.manage.record.exception.RecordException;
import com.google.common.collect.MapMaker;

import java.util.concurrent.ConcurrentMap;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class MemoryInstanceStatusRecorder extends AbstractPumaLifeCycle implements InstanceStatusRecorder {

    private ConcurrentMap<String, InstanceStatus> instanceStatusMap = new MapMaker().makeMap();

    @Override
    public InstanceStatus get(String database) throws RecordException {
        return instanceStatusMap.get(database);
    }

    @Override
    public void record(String database, InstanceStatus instanceStatus) throws RecordException {
        instanceStatusMap.put(database, instanceStatus);
    }
}
