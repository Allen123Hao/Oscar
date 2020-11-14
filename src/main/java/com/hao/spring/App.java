package com.hao.spring;

import com.google.gson.Gson;
import com.hao.corejava.Demo2;
import com.hao.corejava.Demo3;
import com.hao.spring.core.ContextUtils;
import com.hao.spring.core.Student;
import com.hao.spring.schema.ProxyService;
import com.hao.spring.schema.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <code>App</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/8
 * @version: 1.0
 */
public class App {

    public static void testSpringXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        System.out.println("加载spring.xml完毕");
        /**
         Person person = context.getBean(Person.class);
         person.doSomething();
         ((ClassPathXmlApplicationContext) context).close();
         System.out.println("exit");
         **/
        Student student = context.getBean(Student.class);
        System.out.println(new Gson().toJson(student));

//        Demo2 demo2 = context.getBean(Demo2.class);
//        demo2.printConfig(Demo3.HDFSConfigKey.FS_HDFS_IMPL);
//        Demo3.HDFSConfig.getFsHdfsImpl();
    }

    public static void testSpringSCFXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-scf.xml");
        ContextUtils.setApplicationContext(context);
        System.out.println("加载spring-scf.xml完毕");
        TestService testService = (TestService) context.getBean("testService");
        testService.testInvoke();
        ProxyService proxyService = (ProxyService) ContextUtils.getBean("proxyService");
        proxyService.invoke();

    }

    public static void main(String[] args){
//        App.testSpringXml();
        App.testSpringSCFXml();
    }
}
