package com.hao.spring.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ApplicationContextRegister implements ApplicationContextAware,InitializingBean {
    private static Log log = LogFactory.getLog(ContextUtils.class);

    @Autowired
    private Student student;

    private String name;

    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextRegister.setApplicationContext==="+applicationContext);
        System.out.println("Student.name:"+student.getName()+",age:"+student.getAge());
        System.out.println("name===:"+name);
        synchronized (ContextUtils.class) {
            log.debug("setApplicationContext, notifyAll");
            ContextUtils.applicationContext = applicationContext;
            ContextUtils.class.notifyAll();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        System.out.println("ApplicationContextRegister.afterPropertiesSet===");
        System.out.println("name+++:"+name);
    }
}
