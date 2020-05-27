package com.hao.java8.interfacepkg;

/**
 * <code>IMessage</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-03-06
 * @version: 1.0
 */
public interface IMessage {

    void print(String msg);

    /**
     * 默认方法
     * @param msg
     */
    public default void send(String msg){
        System.out.println(msg);
    }

    /**
     * 静态方法
     * @param msg
     */
    public static void receive(String msg){
        System.out.println(msg);
    }
}
