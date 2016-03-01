package com.dianping.puma.node.parse.meta;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaotian.li on 16/2/26.
 * Email: lixiaotian07@gmail.com
 */
public class Meta {

    private String database;

    private String table;

    private Map<Integer, String> fieldMap;

    private Map<Integer, String> typeMap;

    private Map<Integer, Boolean> signedMap;

    private Map<Integer, Boolean> NullMap;

    private Map<Integer, Boolean> keyMap;

    private Map<Integer, Byte> rawTypeCodes;

    private List<Integer> rawNullAbilities;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Map<Integer, String> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(Map<Integer, String> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public Map<Integer, String> getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(Map<Integer, String> typeMap) {
        this.typeMap = typeMap;
    }

    public Map<Integer, Boolean> getNullMap() {
        return NullMap;
    }

    public void setNullMap(Map<Integer, Boolean> nullMap) {
        NullMap = nullMap;
    }

    public Map<Integer, Boolean> getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(Map<Integer, Boolean> keyMap) {
        this.keyMap = keyMap;
    }

    public Map<Integer, Byte> getRawTypeCodes() {
        return rawTypeCodes;
    }

    public void setRawTypeCodes(Map<Integer, Byte> rawTypeCodes) {
        this.rawTypeCodes = rawTypeCodes;
    }

    public List<Integer> getRawNullAbilities() {
        return rawNullAbilities;
    }

    public void setRawNullAbilities(List<Integer> rawNullAbilities) {
        this.rawNullAbilities = rawNullAbilities;
    }

    public Map<Integer, Boolean> getSignedMap() {
        return signedMap;
    }

    public void setSignedMap(Map<Integer, Boolean> signedMap) {
        this.signedMap = signedMap;
    }
}
