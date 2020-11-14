package com.hao.spring.core;

/**
 * <code>StudenAction</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/15
 * @version: 1.0
 */
public class StudenAction {
    private String name;

//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public StudenAction(String name){
        System.out.println("执行StudenAction的构造方法，name:"+name);
        this.name = name;
    }

    public void call(){
        if(name == null){
            name = "张三";
        }
        System.out.println("My name is " + name);
    }
}
