package com.dianping.puma.test;

import com.dianping.puma.common.model.InstanceConfig;
import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class TestingPumaServerDebug {

    public static void main(String[] args) {
        TestingPumaServer testingPumaServer = new TestingPumaServer();
        testingPumaServer.start();

        InstanceConfig instanceConfig = new InstanceConfig();
        instanceConfig.setDatabase("hello");
        testingPumaServer.setInstanceConfig("hello", instanceConfig);

        Uninterruptibles.sleepUninterruptibly(20, TimeUnit.SECONDS);
    }
}
