package com.example.config;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/28 16:00
 */
public class DbConfig {
    public DbConfig() {

    }
    protected static final Map<String, Pair<String, String>> DB_TYPE_MAP = new HashMap<String, Pair<String, String>>();
    static {
        DB_TYPE_MAP.put("mysql", new Pair("jdbc:mysql://%s:%s/%s?characterEncoding=utf8&useSSL=false",
                "com.mysql.jdbc.Driver"));
    }
    private Map<String, DbItem> dbMap;

    public DbConfig(Map<String, DbItem> dbMap) {
        super();
        this.dbMap = dbMap;
    }

    public DbItem getDb(String key) {
        return dbMap.get(key);
    }

}
