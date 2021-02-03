package com.hao.java8.inherit;

/**
 * <code>B</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-12-09
 * @version: 1.0
 */
public interface B {
    void say();

    default void speak1(){
        System.out.println("A");
    }
}
