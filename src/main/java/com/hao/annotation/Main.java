package com.hao.annotation;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.util.Arrays;

/**
 * <code>Main</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/7/3
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Object object = new SayHello();
        Class clazz = object.getClass();
        if(clazz.isAnnotationPresent(RPCService.class)){
            System.out.println("RPCService");
        }
        RPCService rpcService = (RPCService) clazz.getAnnotation(RPCService.class);
        String name = rpcService.value().getName();
        System.out.println(name);
        boolean isComponent = clazz.isAnnotationPresent(Component.class);
        System.out.println(isComponent);
        Component component = AnnotatedElementUtils.getMergedAnnotation(clazz,Component.class);
        System.out.println(component.value());
        System.out.println(component);
        Controller controller = AnnotatedElementUtils.getMergedAnnotation(clazz, Controller.class);
        System.out.println(controller);
        System.out.println(AnnotatedElementUtils.isAnnotated(clazz,"org.springframework.stereotype.Component"));
        System.out.println(AnnotatedElementUtils.isAnnotated(clazz,"org.springframework.stereotype.Controller"));
        Annotation[] annotations = AnnotationUtils.getAnnotations(clazz);
        Arrays.stream(annotations).forEach(a -> System.out.println(a));
    }
}
