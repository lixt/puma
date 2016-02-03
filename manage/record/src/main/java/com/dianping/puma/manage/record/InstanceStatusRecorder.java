package com.dianping.puma.manage.record;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.common.model.InstanceStatus;
import com.dianping.puma.manage.record.exception.RecordException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public interface InstanceStatusRecorder extends PumaLifeCycle {

    InstanceStatus get(String database) throws RecordException;

    void record(String database, InstanceStatus instanceStatus) throws RecordException;
}
