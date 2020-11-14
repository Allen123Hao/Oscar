package com.hao.log;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * <code>Log4j2Test</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-08-26
 * @version: 1.0
 */
public class Log4j2Test {

    /**
     * 测试加载任意jar包中的文件
     */
    @Test
    public void func1(){
        try {
            final Enumeration<URL> resourceEnum = Thread.currentThread().getContextClassLoader().getResources("log4j2.component.properties");
            if(resourceEnum.hasMoreElements()){
                URL url = resourceEnum.nextElement();
                System.out.println(url.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
