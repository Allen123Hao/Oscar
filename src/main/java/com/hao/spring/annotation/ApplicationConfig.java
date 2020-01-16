package com.hao.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <code>ApplicationConfig</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/1/23
 * @version: 1.0
 */
@Configuration
public class ApplicationConfig {
    @Bean
    public OrderService orderService(){
        return new OrderService();
    }
}
