package com.example;

import com.example.config.DbConfig;
import com.example.enabletest.EnableSomeBeans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/28 16:32
 */
@SpringBootApplication(scanBasePackages = { "com.example" })
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        System.out.println(run.getBean("bean1"));
    }
}
