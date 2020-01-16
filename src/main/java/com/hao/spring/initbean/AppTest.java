package com.hao.spring.initbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * <code>AppTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/5/30
 * @version: 1.0
 */
public class AppTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/hao/spring/initbean/applicationContext-test.xml");
//        Employee employee = (Employee) context.getBean("employee1");
//        System.out.println("**********从Spring BeanFactory获取到的最终bean实例**********");
//        System.out.println("最终bean的值：" + employee);
//
//        employee.test();

        Employer employer = (Employer) context.getBean("employer");
        employer.test();
    }
}
