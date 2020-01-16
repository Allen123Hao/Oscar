package com.hao.classloader;

import java.util.Date;

/**
 * <code>AbcBean</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/13
 * @version: 1.0
 */
public class AbcBean {
    @Override
    public String toString() {
        return "AbcBean [name=" + name + ", age=" + age + "]";
    }

    String name;
    int age;
    Date birthDay;

    public Date getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void greeting() {
        System.out.println("AbcBean.greeting()");
    }
}
