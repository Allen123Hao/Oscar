package com.hao.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <code>Main</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/15
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Server start!!!");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("applicationContext1:"+applicationContext);
//        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("/spring.xml");
//        System.out.println("applicationContext2:"+applicationContext2);
        StudenAction studenAction = (StudenAction) ContextUtils.getBean("studentAction");
        studenAction.call();
    }
}
