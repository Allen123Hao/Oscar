package com.hao.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * <code>ComponentAnnotationTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/1/23
 * @version: 1.0
 */
@Configuration
public class ComponentAnnotationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ComponentAnnotationTest.class);
        annotationConfigApplicationContext.refresh();
        InjectClass injectClass = annotationConfigApplicationContext.getBean(InjectClass.class);
        injectClass.print();
    }

    @MyComponent
    public static class InjectClass{
        public void print(){
            System.out.println("Hello World!!!");
        }
    }

}
