package com.example.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;


/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/28 15:59
 */
@Component
public class DbCfgFactoryBean implements FactoryBean<DbConfig> {

    @Value("${dbcfg.filepath}")
    private String dbcfgpath;

    private DbConfig dbConfig;

    public DbConfig getObject() throws Exception {
      return createDbConfig();
    }

    public Class<?> getObjectType() {
        return DbConfig.class;
    }

    public boolean isSingleton() {
        return true;
    }

    private DbConfig createDbConfig(){
        Reader reader = null;
        ResourceLoader loader = new DefaultResourceLoader();
        EncodedResource encodedResource = new EncodedResource(loader.getResource(dbcfgpath),"UTF-8");
        try{
            reader = encodedResource.getReader();
            load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dbConfig;
    }
    private void load(Reader reader) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,DbItem> map = objectMapper.readValue(reader, new TypeReference<Map<String, DbItem>>() {
        });
        dbConfig = new DbConfig(map);
    }
}
