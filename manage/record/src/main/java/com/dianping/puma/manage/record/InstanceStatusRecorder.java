package com.dianping.puma.manage.record;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.common.model.InstanceStatus;
import com.dianping.puma.manage.record.exception.PumaRecordException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public interface InstanceStatusRecorder extends PumaLifeCycle {

    void set(String database, InstanceStatus instanceStatus) throws PumaRecordException;
}
