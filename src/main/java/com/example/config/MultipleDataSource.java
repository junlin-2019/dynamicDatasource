package com.example.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/28 17:32
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceName = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceName.set(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceName.get();
    }
}
