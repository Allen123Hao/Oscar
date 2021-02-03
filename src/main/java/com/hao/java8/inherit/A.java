package com.hao.java8.inherit;

/**
 * <code>A</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-12-09
 * @version: 1.0
 */
public interface A {
    void say();

    default void speak(){
        System.out.println("A");
    }
}
