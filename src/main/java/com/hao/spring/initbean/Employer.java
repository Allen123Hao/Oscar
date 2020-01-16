package com.hao.spring.initbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * <code>Employer</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/5/30
 * @version: 1.0
 */
public class Employer {

    public Employer(){
        System.out.println("构造方法Employer()");
    }

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("Employer postProcessBeforeInitialization,bean:"+bean+",beanName:"+beanName);
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("Employer postProcessAfterInitialization,bean:"+bean+",beanName:"+beanName);
//        return bean;
//    }


    public void test(){
        System.out.println("执行employer的test方法");
    }
}
