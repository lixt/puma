package com.dianping.puma.manage.merge;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.common.model.MergedInstanceConfig;
import com.dianping.puma.manage.merge.exception.PumaMergeException;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public interface InstanceConfigMerger extends PumaLifeCycle {

    MergedInstanceConfig merge(InstanceConfig instanceConfig) throws PumaMergeException;

    MergedInstanceConfig merge(MergedInstanceConfig mergedInstanceConfig,
                               InstanceConfig instanceConfig) throws PumaMergeException;

    MergedInstanceConfig unmerge(MergedInstanceConfig mergedInstanceConfig,
                                 InstanceConfig instanceConfig) throws PumaMergeException;
}
