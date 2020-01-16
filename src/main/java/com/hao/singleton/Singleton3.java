package com.hao.singleton;

/**
 * <code>Singleton3</code>
 *
 * @description: 饿汉
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/9/20
 * @version: 1.0
 */
public class Singleton3 {
    private static Singleton3 instance = new Singleton3();

    private Singleton3(){
        System.out.println("Singleton3 构造方法.");
    }

    public static Singleton3 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton3 singleton1 = Singleton3.getInstance();
        System.out.println(singleton1.hashCode());
        Singleton3 singleton2 = Singleton3.getInstance();
        System.out.println(singleton2.hashCode());
    }
}
