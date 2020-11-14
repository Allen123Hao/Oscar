package com.hao.bytecode;

/**
 * <code>Person</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-09-30
 * @version: 1.0
 */
public class Person {

    private String name;
    private int age;

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

    public String getInfo(){
        return getName()+"\t"+getAge();
    }

    public String setDesc(String desc){
        return desc;
    }

    public int setAgeDesc(String desc){
        return age;
    }

    public String getDesc(String desc){
        return setDesc("Allen");
    }

    public int getAgeDesc(String desc){
        setAgeDesc("Allen");
        return age;
    }
}