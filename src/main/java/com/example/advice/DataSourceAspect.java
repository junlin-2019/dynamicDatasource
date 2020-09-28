package com.example.advice;

import com.example.annotation.DataSource;
import com.example.config.DataSourceConstant;
import com.example.config.MultipleDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/28 17:50
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {


    @Pointcut("@annotation(com.example.annotation.DataSource)")
    public void advice(){}


    @Around("advice()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object result =null;
        if(pjp.getSignature() instanceof MethodSignature){
            MethodSignature signature = (MethodSignature) pjp.getSignature();
            DataSource annotation = signature.getMethod().getAnnotation(DataSource.class);
            if(annotation!=null){
                MultipleDataSource.setDataSourceKey(annotation.value());
            }
        }
        try {
            result = pjp.proceed();
        }finally {
            MultipleDataSource.setDataSourceKey(DataSourceConstant.DEFAULT_DATASOURCE);
        }
        return  result;
    }
    public int getOrder() {
        return 0;
    }
}
