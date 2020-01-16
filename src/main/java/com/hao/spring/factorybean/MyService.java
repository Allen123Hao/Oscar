package com.hao.spring.factorybean;

/**
 * <code>MyService</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2019-10-23
 * @version: 1.0
 */
public class MyService {

    private String name;

    public MyService(String name){
        this.name = name;
    }

    public void print(){
        System.out.println("This is "+name);
    }
}
