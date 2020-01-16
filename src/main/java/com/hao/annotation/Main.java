package com.hao.annotation;

import java.lang.annotation.Annotation;

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
        RPCService rpcService = (RPCService) clazz.getAnnotation(RPCService.class);
        String name = rpcService.value().getName();
        System.out.println(name);
    }
}
