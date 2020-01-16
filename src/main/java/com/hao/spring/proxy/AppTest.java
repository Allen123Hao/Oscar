package com.hao.spring.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.lang.reflect.Proxy;

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
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/hao/spring/proxy/applicationContext-test.xml");
        MyTarget target = (MyTarget) context.getBean("myPrint");
        target.print("AllenHao");
    }
}
