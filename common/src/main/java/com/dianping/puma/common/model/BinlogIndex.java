package com.dianping.puma.common.model;

import lombok.ToString;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
@ToString
public class BinlogIndex {

    private Long binlogTimestamp;

    private BinlogPosition binlogPosition;

    public Long getBinlogTimestamp() {
        return binlogTimestamp;
    }

    public void setBinlogTimestamp(Long binlogTimestamp) {
        this.binlogTimestamp = binlogTimestamp;
    }

    public BinlogPosition getBinlogPosition() {
        return binlogPosition;
    }

    public void setBinlogPosition(BinlogPosition binlogPosition) {
        this.binlogPosition = binlogPosition;
    }
}
