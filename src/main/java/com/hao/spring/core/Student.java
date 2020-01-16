package com.hao.spring.core;

/**
 * <code>Student</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/16
 * @version: 1.0
 */
public class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }
}
