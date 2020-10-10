package com.example.enabletest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/10/9 17:46
 */

@Configuration
@EnableSomeBeans
@ConditionalOnProperty(value = "some.enabled",matchIfMissing = true)
public class TestConfig {

}
