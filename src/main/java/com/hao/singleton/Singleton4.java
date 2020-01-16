package com.hao.singleton;

/**
 * <code>Singleton4</code>
 *
 * @description: 饿汉 变种
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/9/20
 * @version: 1.0
 */
public class Singleton4 {
    private static Singleton4 instance;

    static {
        System.out.println("Singleton4 静态块.");
        instance = new Singleton4();

    }

    private Singleton4(){
        System.out.println("Singleton4 构造方法.");
    }

    public static Singleton4 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton4 singleton1 = Singleton4.getInstance();
        System.out.println(singleton1.hashCode());
        Singleton4 singleton2 = Singleton4.getInstance();
        System.out.println(singleton2.hashCode());
    }
}
