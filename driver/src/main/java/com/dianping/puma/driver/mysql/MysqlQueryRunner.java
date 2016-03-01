package com.dianping.puma.driver.mysql;

import java.sql.ResultSet;

/**
 * Created by xiaotian.li on 16/2/26.
 * Email: lixiaotian07@gmail.com
 */
public class MysqlQueryRunner {

    private String host;

    private Integer port;

    private String username;

    private String password;

    public void connect() {

    }

    public ResultSet query(String queryString) {
        return null;
    }

    public void close() {

    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
