package com.dianping.puma.replicate.mysql;

import com.dianping.puma.common.model.BinlogCursor;
import com.dianping.puma.common.model.BinlogServer;
import com.google.common.collect.Sets;

/**
 * Created by xiaotian.li on 16/2/19.
 * Email: lixiaotian07@gmail.com
 */
public class SimpleMysqlReplicatorIntegrationTest {

    public static void main(String[] args) {
        SimpleMysqlReplicator replicator = new SimpleMysqlReplicator();
        replicator.setCluster("test-cluster");
        replicator.setDatabases(Sets.newHashSet("test-database"));

        BinlogCursor binlogCursor = new BinlogCursor();
        binlogCursor.setBinlogTimestamp(1L);
        binlogCursor.setServerId(2L);
        binlogCursor.setBinlogFileName("mysql-bin.000001");
        binlogCursor.setBinlogPosition(4L);
        replicator.setBinlogCursor(binlogCursor);

        BinlogServer binlogServer = new BinlogServer();
        binlogServer.setHost("127.0.0.1");
        binlogServer.setPort(3306);
        binlogServer.setBinlogUsername("test");
        binlogServer.setBinlogPassword("123456");
        binlogServer.setMaster(true);
        replicator.setBinlogServer(binlogServer);

        replicator.setConnectTimeoutInSecond(5);

        replicator.start();
    }
}
