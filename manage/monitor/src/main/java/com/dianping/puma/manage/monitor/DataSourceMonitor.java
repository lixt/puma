package com.dianping.puma.manage.monitor;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.instance.core.model.SQLServer;
import com.dianping.puma.manage.monitor.exception.MonitorException;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public interface DataSourceMonitor extends PumaLifeCycle {

    List<SQLServer> getSQLServers(String database) throws MonitorException;
}
