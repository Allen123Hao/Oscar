package com.hao.spring.event;

import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * <code>AppTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2019-11-05
 * @version: 1.0
 */
public class AppTest {

    public static void main(String[] args) {
        String path = AppTest.class.getResource("").getPath();

        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("/"+path+"spring-context.xml");
        boolean isSingleton = context.getBeanFactory().isSingleton("testListener");
        System.out.println("TestListener isSingleton:"+isSingleton);

        SimpleApplicationEventMulticaster eventMulticaster = (SimpleApplicationEventMulticaster) context.getBean("applicationEventMulticaster");
        System.out.println("eventMulticaster:"+eventMulticaster);

        System.out.println("main thread:"+Thread.currentThread().getName());
        TestParam testParam = new TestParam();
        testParam.setEmail("xiaoqiang-0504@163.com");
        TestEvent testEvent = new TestEvent(testParam);
        context.publishEvent(testEvent);

//        TestParam testParam1 = new TestParam();
//        testParam1.setEmail("xiaoqiang-0504@163.com");
//        TestEvent testEvent1 = new TestEvent(testParam1);
//        context.publishEvent(testEvent1);
    }
}
