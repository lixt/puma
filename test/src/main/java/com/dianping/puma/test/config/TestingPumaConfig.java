package com.dianping.puma.test.config;

import com.dianping.puma.server.config.PumaConfig;
import com.dianping.puma.server.config.mode.MonitorMode;
import com.dianping.puma.server.config.mode.RecordMode;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class TestingPumaConfig extends PumaConfig {

    // Puma instance config monitor configuration.
    private MonitorMode monitorMode = MonitorMode.MEMORY;

    private Long monitorScanIntervalInSecond = 5L; // 5s.

    // Puma instance status recorder configuration.
    private RecordMode recordMode = RecordMode.MEMORY;

    public MonitorMode getMonitorMode() {
        return monitorMode;
    }

    public void setMonitorMode(MonitorMode monitorMode) {
        this.monitorMode = monitorMode;
    }

    public Long getMonitorScanIntervalInSecond() {
        return monitorScanIntervalInSecond;
    }

    public void setMonitorScanIntervalInSecond(Long monitorScanIntervalInSecond) {
        this.monitorScanIntervalInSecond = monitorScanIntervalInSecond;
    }

    public RecordMode getRecordMode() {
        return recordMode;
    }

    public void setRecordMode(RecordMode recordMode) {
        this.recordMode = recordMode;
    }
}
