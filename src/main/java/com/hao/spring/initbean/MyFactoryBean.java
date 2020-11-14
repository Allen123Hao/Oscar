package com.hao.spring.initbean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * <code>MyFactoryBean</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-09-09
 * @version: 1.0
 */
public class MyFactoryBean implements FactoryBean, InitializingBean {

    @Override
    public Object getObject() throws Exception {
        System.out.println("执行getObject");
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行afterPropertiesSet");
    }
}
