package com.hao.spring.initbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * <code>MyBeanPostProcessor</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/5/30
 * @version: 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor, BeanDefinitionRegistryPostProcessor {

    public String name;

    public void setName(String name){
        this.name = name;
    }

    public MyBeanPostProcessor() {
        System.out.println("执行MyBeanPostProcessor的无参构造方法");
    }

    public MyBeanPostProcessor(String name) {
        System.out.println("执行MyBeanPostProcessor的有参构造方法");
        this.name = name;
    }

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

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("***开始执行postProcessBeanFactory***");
        String[] names = beanFactory.getBeanDefinitionNames();
        // 获取了所有的bean名称列表
        for(int i=0; i<names.length; i++){
            String name = names[i];

            BeanDefinition bd = beanFactory.getBeanDefinition(name);
            System.out.println(name + " bean properties: " + bd.getPropertyValues().toString());
            // 本内容只是个demo，打印持有的bean的属性情况
        }
        System.out.println("***结束执行postProcessBeanFactory***");

    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("***开始执行postProcessBeanDefinitionRegistry***");
        System.out.println("BeanDefinitionCount:"+registry.getBeanDefinitionCount());
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Employer3.class);
        registry.registerBeanDefinition("employer3",rootBeanDefinition);
        System.out.println("***结束执行postProcessBeanDefinitionRegistry***");
    }
}
