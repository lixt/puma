package com.dianping.puma.replicate.ha;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.common.model.BinlogServer;

/**
 * Created by xiaotian.li on 16/2/21.
 * Email: lixiaotian07@gmail.com
 */
public interface BinlogRouter extends PumaLifeCycle {

    BinlogServer next();

    BinlogServer getByServerId(Long serverId);
}
