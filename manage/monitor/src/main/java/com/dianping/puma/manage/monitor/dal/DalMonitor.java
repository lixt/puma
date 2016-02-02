package com.dianping.puma.manage.monitor.dal;

import com.dianping.puma.instance.core.model.DbServer;
import com.dianping.puma.manage.monitor.PumaMonitor;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public interface DalMonitor extends PumaMonitor {

    List<DbServer> getDbServers(String databaseName);
}
