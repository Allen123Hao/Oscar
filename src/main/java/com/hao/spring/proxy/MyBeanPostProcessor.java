package com.hao.spring.proxy;

//import org.jboss.netty.util.internal.ConcurrentHashMap;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <code>MyBeanPostProcessor</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/5/30
 * @version: 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    private Map map = new ConcurrentHashMap<>(100);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("进入postProcessBeforeInitialization方法");
        MyProxy proxy = new MyProxy();
        if(map.containsKey(beanName)){
            return bean;
        }
        if(bean instanceof MyTarget){
            proxy.setTarget(bean);
            proxy.setName(beanName);
            Class[] iteClass = bean.getClass().getInterfaces();
            if(iteClass.length > 0){
                Object proxy0 = Proxy.newProxyInstance(bean.getClass().getClassLoader(),iteClass,proxy);
                map.put(beanName,proxy0);
                return proxy0;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("进入postProcessAfterInitialization方法");
        return bean;
    }
}
