package com.example.config;

import com.zaxxer.hikari.HikariDataSource;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/28 17:13
 */

@Configuration
public class DataSourceConfig {

    @Autowired
    private DbConfig dbConfig;

    @Value("${spring.datasource.minIdle:10}")
    private int minIdle;

    @Value("${spring.datasource.maxActive:50}")
    private int maxActive;
    @Value("${spring.datasource.maxLifetime}")
    private int maxLifetime;
    @Value("${spring.datasource.idleTimeout}")
    private int idleTimeout;

    @Value("${datasource.db02}")
    private String dataSource02;

    @Value("${datasource.db01}")
    private String dataSource01;


    @Bean("dataSource01")
    public DataSource dataSource01(){
        return initDataSource(dataSource01);
    }

    @Bean("dataSource02")
    public DataSource dataSource02(){
        return initDataSource(dataSource02);
    }

    @Bean("multipleDataSource")
    public DataSource multipleDataSource(@Qualifier("dataSource01") DataSource dataSource01,
                                         @Qualifier("dataSource02") DataSource dataSource02) {
        Map<Object, Object> datasources = new HashMap<Object, Object>();
        datasources.put(DataSourceConstant.DEFAULT_DATASOURCE, dataSource01);
        datasources.put(DataSourceConstant.DATASOURCE_02, dataSource02);
        MultipleDataSource multipleDataSource = new MultipleDataSource();
        multipleDataSource.setDefaultTargetDataSource(dataSource01);
        multipleDataSource.setTargetDataSources(datasources);
        return multipleDataSource;
    }

    private DataSource initDataSource(String dbName) {
        HikariDataSource datasource = new HikariDataSource();
        datasource.setJdbcUrl(dbConfig.getDb(dbName).getUrl());
        datasource.setUsername(dbConfig.getDb(dbName).getUsername());
        datasource.setPassword(dbConfig.getDb(dbName).getPassword());
        datasource.setDriverClassName(dbConfig.getDb(dbName).getDriverClassName());
        datasource.setMaximumPoolSize(maxActive);
        datasource.setMinimumIdle(minIdle);
        datasource.setMaxLifetime(maxLifetime);
        datasource.setIdleTimeout(idleTimeout);
        datasource.setConnectionTestQuery("select 1");
        datasource.addDataSourceProperty("cachePrepStmts", "true"); // 是否自定义配置，为true时下面两个参数才生效
        datasource.addDataSourceProperty("prepStmtCacheSize", "250"); // 连接池大小默认25，官方推荐250-500
        datasource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048"); // 单条语句最大长度默认256，官方推荐2048
        datasource.addDataSourceProperty("useServerPrepStmts", "true"); // 新版本MySQL支持服务器端准备，开启能够得到显著性能提升
        datasource.addDataSourceProperty("useLocalSessionState", "true");
        datasource.addDataSourceProperty("useLocalTransactionState", "true");
        datasource.addDataSourceProperty("rewriteBatchedStatements", "true");
        datasource.addDataSourceProperty("cacheResultSetMetadata", "true");
        datasource.addDataSourceProperty("cacheServerConfiguration", "true");
        datasource.addDataSourceProperty("elideSetAutoCommits", "true");
        datasource.addDataSourceProperty("maintainTimeStats", "false");
        return datasource;
    }
}
