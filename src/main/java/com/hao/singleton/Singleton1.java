package com.hao.singleton;

/**
 * <code>Singleton1</code>
 *
 * @description: 懒汉 非安全
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/9/20
 * @version: 1.0
 */
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1(){
        System.out.println("Singleton1 构造方法.");
    }

    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println(singleton1.hashCode());
        Singleton1 singleton2 = Singleton1.getInstance();
        System.out.println(singleton2.hashCode());
    }

}
