package com.hao.singleton;

/**
 * <code>Singleton6</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/9/20
 * @version: 1.0
 */
public enum Singleton6 {
    INSTANCE;
    Singleton6(){
        System.out.println("Singleton6 构造方法。");
    }
    public void whateverMethod(){
        System.out.println("This is Singleton6.");
    }

    public static void main(String[] args) {
        Singleton6 singleton6 = Singleton6.INSTANCE;
        System.out.println(singleton6.hashCode());
        Singleton6 singleton6_1 = Singleton6.INSTANCE;
        System.out.println(singleton6_1.hashCode());
    }
}
