package com.dianping.puma.common.model;

/**
 * Created by xiaotian.li on 16/2/21.
 * Email: lixiaotian07@gmail.com
 */
public class BinlogPosition {

    private Long serverId;

    private String binlogFileName;

    private Long binlogFileOffset;

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

    public Long getBinlogFileOffset() {
        return binlogFileOffset;
    }

    public void setBinlogFileOffset(Long binlogFileOffset) {
        this.binlogFileOffset = binlogFileOffset;
    }
}
