package com.hao.lambda.functional;

/**
 * <code>GreetingService</code>
 *
 * @description: @FunctionalInterface的使用
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-06-02
 * @version: 1.0
 */
@FunctionalInterface
public interface GreetingService {

    //接口中包含了一个抽象方法
    void sayMessage(String name,String message);

    //函数式接口里允许定义默认方法
    default void doWork(){

    }

    default void doMoreWork(){

    }

    //函数式接口里允许定义静态方法
    static void printMsg(){

    }

    //函数式接口里允许定义java.lang.Object里的public方法
    @Override
    boolean equals(Object obj);
}
