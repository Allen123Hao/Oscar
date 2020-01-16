package com.hao.spring;

import com.hao.corejava.Demo2;
import com.hao.corejava.Demo3;
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
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        System.out.println("加载spring.xml完毕");
        /**
        Person person = context.getBean(Person.class);
        person.doSomething();
        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("exit");
         **/
        Demo2 demo2 = context.getBean(Demo2.class);
        demo2.printConfig(Demo3.HDFSConfigKey.FS_HDFS_IMPL);
        Demo3.HDFSConfig.getFsHdfsImpl();
    }
}
