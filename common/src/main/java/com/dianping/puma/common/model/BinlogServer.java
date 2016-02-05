package com.dianping.puma.common.model;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class BinlogServer {

    private long serverId;

    private String address;

    private String binlogUsername;

    private String binlogPassword;

    private boolean master;

    public long getServerId() {
        return serverId;
    }

    public void setServerId(long serverId) {
        this.serverId = serverId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
