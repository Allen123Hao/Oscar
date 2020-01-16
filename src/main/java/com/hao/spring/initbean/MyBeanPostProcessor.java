package com.hao.spring.initbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * <code>MyBeanPostProcessor</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/5/30
 * @version: 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("进入postProcessBeforeInitialization,bean:"+bean+",beanName:"+beanName);
        if(bean instanceof Employer){
            System.out.println("初始化之前处理,bean:"+bean+",beanName:"+beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("进入postProcessAfterInitialization,bean:"+bean+",beanName:"+beanName);
        if(bean instanceof Employer){
            System.out.println("初始化之后处理,bean:"+bean+",beanName:"+beanName);
        }
        return bean;
    }
}
