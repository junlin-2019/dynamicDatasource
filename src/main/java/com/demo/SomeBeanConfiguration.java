package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/10/9 17:43
 */
@Configuration
public class SomeBeanConfiguration {

    @Bean("bean1")
    public String Bean1() {
        return "Bean1";
    }

    @Bean("bean2")
    public String Bean2() {
        return "Bean2";
    }
}
