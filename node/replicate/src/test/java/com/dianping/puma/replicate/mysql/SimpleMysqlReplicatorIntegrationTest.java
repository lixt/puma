package com.dianping.puma.replicate.mysql;

import com.dianping.puma.common.model.BinlogIndex;
import com.dianping.puma.common.model.SQLServer;

/**
 * Created by xiaotian.li on 16/2/19.
 * Email: lixiaotian07@gmail.com
 */
public class SimpleMysqlReplicatorIntegrationTest {

    public static void main(String[] args) {
        SimpleMysqlReplicator replicator = new SimpleMysqlReplicator();
        replicator.setCluster("test-cluster");

        BinlogIndex binlogIndex = new BinlogIndex();
        binlogIndex.setBinlogTimestamp(1L);
        binlogIndex.getBinlogPosition().setServerId(2L);
        binlogIndex.getBinlogPosition().setBinlogFileName("mysql-bin.000001");
        binlogIndex.getBinlogPosition().setBinlogFileOffset(4L);
        replicator.setBinlogIndex(binlogIndex);

        SQLServer binlogServer = new SQLServer();
        binlogServer.setHost("127.0.0.1");
        binlogServer.setPort(3306);
        binlogServer.setBinlogUsername("test");
        binlogServer.setBinlogPassword("123456");
        binlogServer.setMaster(true);
        replicator.setBinlogServer(binlogServer);

        replicator.setConnectTimeoutInSecond(5);

        replicator.start();

        replicator.replicate();
    }
}
