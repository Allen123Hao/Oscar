package com.hao.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <code>ConfigurationTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/1/23
 * @version: 1.0
 */
public class ConfigurationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OrderService orderService = annotationConfigApplicationContext.getBean(OrderService.class);
        orderService.print();
    }
}
