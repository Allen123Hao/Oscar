package com.hao.singleton;

/**
 * <code>Singleton</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/9/20
 * @version: 1.0
 */
public class Singleton {
    public Singleton(){
        System.out.println();
    }

    public static void main(String[] args) {
        Singleton singleton1 = new Singleton();
        System.out.println(singleton1.hashCode());
        Singleton singleton2 = new Singleton();
        System.out.println(singleton2.hashCode());
    }
}
