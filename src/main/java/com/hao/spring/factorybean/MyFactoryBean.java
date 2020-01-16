package com.hao.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * <code>MyFactoryBean</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2019-10-23
 * @version: 1.0
 */
public class MyFactoryBean implements FactoryBean<IService> {

    private IService service;

    @Override
    public IService getObject() throws Exception {
        return new ServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return IService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
