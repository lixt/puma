package com.dianping.puma.common.model;

import lombok.ToString;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
@ToString
public class BinlogServer {

    private long serverId;

    private String host;

    private int port;

    private String binlogUsername;

    private String binlogPassword;

    private boolean master;

    public long getServerId() {
        return serverId;
    }

    public void setServerId(long serverId) {
        this.serverId = serverId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getBinlogUsername() {
        return binlogUsername;
    }

    public void setBinlogUsername(String binlogUsername) {
        this.binlogUsername = binlogUsername;
    }

    public String getBinlogPassword() {
        return binlogPassword;
    }

    public void setBinlogPassword(String binlogPassword) {
        this.binlogPassword = binlogPassword;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }
}
