package com.hao.rpc;

/**
 * <code>PersonServer</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/16
 * @version: 1.0
 */
public class PersonServer implements Person{
    private int age;

    private String name;

    public PersonServer(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public int getAge() throws Throwable {
        return age;
    }

    @Override
    public String getName() throws Throwable {
        return name;
    }
}
