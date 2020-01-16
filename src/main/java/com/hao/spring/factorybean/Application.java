package com.hao.spring.factorybean;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * <code>Application</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2019-10-23
 * @version: 1.0
 */
public class Application {

    public static void main(String[] args) {
        String path = Application.class.getResource("").getPath();
        System.out.println(path);
//        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("/"+path+"spring-factorybean.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-factorybean.xml");
        MyService myService1 = context.getBean(MyService.class);
        MyService myService2 = context.getBean(MyService.class);
        System.out.println(myService1);
        System.out.println(myService2);
        if(myService1.equals(myService2)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        myService1.print();
    }
}
