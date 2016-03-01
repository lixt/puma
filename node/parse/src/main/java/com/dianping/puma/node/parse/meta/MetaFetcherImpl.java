package com.dianping.puma.node.parse.meta;

import com.dianping.puma.driver.mysql.MysqlQueryRunner;
import com.dianping.puma.node.parse.exception.PumaMetaException;
import com.google.common.collect.Maps;

import java.sql.ResultSet;
import java.util.Map;

/**
 * Created by xiaotian.li on 16/2/26.
 * Email: lixiaotian07@gmail.com
 */
public class MetaFetcherImpl extends AbstractMetaFetcher {

    private static final String META_FIELD = "Field";
    private static final String META_TYPE = "Type";
    private static final String META_NULL = "Null";
    private static final String META_KEY = "Key";

    private static final String META_NULL_YES = "YES";
    private static final String META_KEY_PRI = "PRI";

    private String host;
    private Integer port;
    private String username;
    private String password;

    private MysqlQueryRunner metaQueryRunner;

    @Override
    public Meta getMeta(String database, String table) throws PumaMetaException {
        try {
            String metaQueryString = generateMetaQueryString(database, table);
            ResultSet resultSet = metaQueryRunner.query(metaQueryString);

            Map<Integer, String> fieldMap = Maps.newHashMap();
            Map<Integer, String> typeMap = Maps.newHashMap();
            Map<Integer, Boolean> nullMap = Maps.newHashMap();
            Map<Integer, Boolean> keyMap = Maps.newHashMap();

            while (resultSet.next()) {
                int ordinal = resultSet.getRow();

                String metaField = resultSet.getString(META_FIELD);
                fieldMap.put(ordinal, metaField);

                String metaType = resultSet.getString(META_TYPE);
                typeMap.put(ordinal, metaType);

                Boolean metaNull = resultSet.getString(META_NULL).equals(META_NULL_YES);
                nullMap.put(ordinal, metaNull);

                Boolean metaKey = resultSet.getString(META_KEY).equals(META_KEY_PRI);
                keyMap.put(ordinal, metaKey);
            }

            Meta meta = new Meta();
            meta.setDatabase(database);
            meta.setTable(table);
            meta.setFieldMap(fieldMap);
            meta.setTypeMap(typeMap);
            meta.setNullMap(nullMap);
            meta.setKeyMap(keyMap);
            return meta;

        } catch (Throwable t) {
            throw new PumaMetaException("Failed to get meta for database[%s], " +
                    "table[%s].", database, table, t);
        }
    }

    private String generateMetaQueryString(String database, String table) {
        return "dest" + database + "." + table;
    }

    @Override
    protected void connect() {
        metaQueryRunner = new MysqlQueryRunner();
        metaQueryRunner.setHost(host);
        metaQueryRunner.setPort(port);
        metaQueryRunner.setUsername(username);
        metaQueryRunner.setPassword(password);

        metaQueryRunner.connect();
    }

    @Override
    protected void close() {
        metaQueryRunner.close();
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
