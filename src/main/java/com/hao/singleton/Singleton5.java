package com.hao.singleton;

/**
 * <code>Singleton5</code>
 *
 * @description: 静态内部类
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/9/20
 * @version: 1.0
 */
public class Singleton5 {
    private static class SingletonHolder{
        static {
            System.out.println("SingletonHolder 静态块.");
        }
        private static Singleton5 INSTANCE = new Singleton5();
    }

    static {
        System.out.println("Singleton5 静态块.");
    }

    private Singleton5(){
        System.out.println("Singleton5 构造方法.");
    }

    public static Singleton5 getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton5 singleton1 = Singleton5.getInstance();
        System.out.println(singleton1.hashCode());
        Singleton5 singleton2 = Singleton5.getInstance();
        System.out.println(singleton2.hashCode());
    }
}
