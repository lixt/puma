package com.dianping.puma.manage.core.merge;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.common.model.MergedInstanceConfig;
import com.dianping.puma.manage.core.exception.PumaMergedManageException;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public interface MergedInstanceManager extends PumaLifeCycle {

    void load(MergedInstanceConfig config) throws PumaMergedManageException;
}
