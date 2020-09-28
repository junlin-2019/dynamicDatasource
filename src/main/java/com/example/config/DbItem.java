package com.example.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/28 16:03
 */
@Data
public class DbItem {
    @JsonProperty("dbName")
    private String dbName;
    @JsonProperty("dbType")
    private String dbType;
    @JsonProperty("host")
    private String host;
    @JsonProperty("port")
    private String port;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

    public String getUrl() {
        return String.format(DbConfig.DB_TYPE_MAP.get(dbType).getKey(), host, port, dbName);
    }

    public String getDriverClassName() {
        return DbConfig.DB_TYPE_MAP.get(dbType).getValue();
    }

}
