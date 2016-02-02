package com.dianping.puma.manage.monitor.db;

import com.dianping.puma.instance.core.model.DbTask;
import com.dianping.puma.manage.monitor.PumaMonitor;
import com.dianping.puma.manage.monitor.exception.MonitorException;

import java.util.List;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public interface DbTaskMonitor extends PumaMonitor {

    DbTask getDbTask(int taskId) throws MonitorException;

    List<DbTask> getAllDbTasks() throws MonitorException;
}
