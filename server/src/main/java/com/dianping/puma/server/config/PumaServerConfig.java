package com.dianping.puma.server.config;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class PumaServerConfig {

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

    public enum RecordMode {
        /** local, in-memory. */
        MEMORY,
        /** local, properties file. */
        FILE,
        /** remote, mysql. */
        MYSQL,
        /** remote, mongo. */
        MONGO;

        public boolean isMemory() {
            return this.equals(RecordMode.MEMORY);
        }

        public boolean isFile() {
            return this.equals(RecordMode.FILE);
        }

        public boolean isMysql() {
            return this.equals(RecordMode.MYSQL);
        }

        public boolean isMongo() {
            return this.equals(RecordMode.MONGO);
        }
    }
}
