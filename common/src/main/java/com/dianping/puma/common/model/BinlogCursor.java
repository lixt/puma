package com.dianping.puma.common.model;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class BinlogCursor {

    private Long binlogTimestamp;

    private Long serverId;

    private String binlogFileName;

    private Long binlogPosition;

    public Long getBinlogTimestamp() {
        return binlogTimestamp;
    }

    public void setBinlogTimestamp(Long binlogTimestamp) {
        this.binlogTimestamp = binlogTimestamp;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public String getBinlogFileName() {
        return binlogFileName;
    }

    public void setBinlogFileName(String binlogFileName) {
        this.binlogFileName = binlogFileName;
    }

    public Long getBinlogPosition() {
        return binlogPosition;
    }

    public void setBinlogPosition(Long binlogPosition) {
        this.binlogPosition = binlogPosition;
    }
}
