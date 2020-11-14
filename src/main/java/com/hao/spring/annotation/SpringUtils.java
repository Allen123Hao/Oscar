package com.hao.spring.annotation;

import org.junit.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * <code>SpringUtils</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-08-25
 * @version: 1.0
 */
public class SpringUtils {

    @Test
    public void fun1() throws Exception{
//        Class clazz = Thread.currentThread().getContextClassLoader().loadClass("com.hao.spring.annotation.ApplicationConfig");
        Configuration annotation = AnnotationUtils.findAnnotation(ApplicationConfig.class, Configuration.class);
        if(annotation != null){
            System.out.println(annotation.getClass().getName());
        }else{
            System.out.println("null");
        }

    }
}