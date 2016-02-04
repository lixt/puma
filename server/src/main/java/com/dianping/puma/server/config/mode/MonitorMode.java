package com.dianping.puma.server.config.mode;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public enum MonitorMode {

    /** local, in-memory. */
    MEMORY,
    /** local, properties file. */
    FILE,
    /** remote, mysql. */
    MYSQL,
    /** remote, mongo. */
    MONGO;

    public boolean isMemory() {
        return this.equals(MonitorMode.MEMORY);
    }

    public boolean isFile() {
        return this.equals(MonitorMode.FILE);
    }

    public boolean isMysql() {
        return this.equals(MonitorMode.MYSQL);
    }

    public boolean isMongo() {
        return this.equals(MonitorMode.MONGO);
    }
}
