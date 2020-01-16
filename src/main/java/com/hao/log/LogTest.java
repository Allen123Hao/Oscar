package com.hao.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * <code>LogTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-11-26
 * @version: 1.0
 */
public class LogTest {

    private static Logger log = LoggerFactory.getLogger(LogTest.class);

    public static void func1(){
        log.info("测试LogTest");
    }

    public static void func2(){
        try {
            URL url = LogTest.class.getClassLoader().getResource("log/log4j.xml");
            LoggerContext context = (LoggerContext) LogManager.getContext(false);
            context.setConfigLocation(url.toURI());
            context.reconfigure();
            log.info("info测试func2");
            log.debug("debug测试func2");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        func2();
    }
}
