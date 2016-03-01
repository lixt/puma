package com.dianping.puma.node.parse.meta;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.node.parse.exception.PumaMetaException;

/**
 * Created by xiaotian.li on 16/2/26.
 * Email: lixiaotian07@gmail.com
 */
public interface MetaFetcher extends PumaLifeCycle {

    Meta getMeta(String database, String table) throws PumaMetaException;
}
