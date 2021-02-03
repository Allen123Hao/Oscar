package com.hao.java8.inherit;

/**
 * <code>D</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-12-09
 * @version: 1.0
 */
public class D implements C {
    @Override
    public void say() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        D d = new D();
        d.say();
    }
}
