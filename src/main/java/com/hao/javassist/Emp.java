package com.hao.javassist;

import java.util.List;

/**
 * <code>Emp</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-04-24
 * @version: 1.0
 */
public class Emp {
    //属性
    private int    account;
    private String name;

    //构造方法
    public Emp() {
        this.account = 1;
        this.name = "xiaona";
    }

    //有参构造方法
    public Emp(List paramList)
    {
        paramList.get(0);
        paramList.get(1);
    }

    //getter
    public int getAccount() {
        return account;
    }

    //setter
    public void setAccount(int account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //普通方法
    public void commonMethod() {
        System.out.println("haha");
    }
}
