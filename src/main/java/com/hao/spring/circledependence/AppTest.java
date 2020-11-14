package com.hao.spring.circledependence;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * <code>AppTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-10-20
 * @version: 1.0
 */
public class AppTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationTest.class);
        System.out.println("=========");
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(name -> System.out.println(name));
        System.out.println("=========");
        System.out.println("one");
        A a = (A) context.getBean("a");
        a.print();
        a.call();
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/hao/spring/circledependence/spring-circular.xml");
    }
}
