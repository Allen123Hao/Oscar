package com.hao.singleton;

/**
 * <code>Singleton2</code>
 *
 * @description: 懒汉 线程安全
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/9/20
 * @version: 1.0
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2(){
        System.out.println("Singleton2 构造方法.");
    }

    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton2 singleton1 = Singleton2.getInstance();
        System.out.println(singleton1.hashCode());
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2.hashCode());
    }
}
