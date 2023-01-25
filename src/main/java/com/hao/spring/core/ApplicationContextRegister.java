package com.hao.spring.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <code>ApplicationContextRegister</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/15
 * @version: 1.0
 */
public class ApplicationContextRegister implements ApplicationContextAware, BeanFactoryAware,InitializingBean, BeanPostProcessor {
    private static Log log = LogFactory.getLog(ApplicationContextRegister.class);

    private Student student;

    private String name;

    public void setStudent(Student student){
        this.student = student;
    }

    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextRegister.setApplicationContext==="+applicationContext);
        if(student != null){
            System.out.println("Student.name:"+student.getName()+",age:"+student.getAge());
        }else{
            System.out.println("Student:"+student);
        }
        System.out.println("name===:"+name);
        synchronized (ContextUtils.class) {
            log.info("setApplicationContext, notifyAll");
            ContextUtils.applicationContext = applicationContext;
            ContextUtils.class.notifyAll();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        System.out.println("ApplicationContextRegister.afterPropertiesSet===");
        System.out.println("name+++:"+name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("ApplicationContextRegister的setBeanFactory方法");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("ApplicationContextRegister的postProcessBeforeInitialization方法,beanName:"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("ApplicationContextRegister的postProcessAfterInitialization方法,beanName:"+beanName);
        return bean;
    }
}
