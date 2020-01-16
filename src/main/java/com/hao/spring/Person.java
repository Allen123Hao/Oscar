package com.hao.spring;

/**
 * <code>Person</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/8
 * @version: 1.0
 */
public class Person {
    public void initialize() {
        System.out.println("I'm initialized");
    }

    public void destroy() {
        System.out.println("I'm destroied");
    }

    public void doSomething() {
        System.out.println("I'm doSomething");
    }
}
