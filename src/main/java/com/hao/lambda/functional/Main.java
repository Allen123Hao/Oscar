package com.hao.lambda.functional;

/**
 * <code>Main</code>
 *
 * @description: @FunctionalInterface接口的实现
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-06-02
 * @version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        GreetingService greetingService = (allen,message) -> System.out.println(allen + " say "+message);
        greetingService.sayMessage("Allen","Hello");
    }
}
