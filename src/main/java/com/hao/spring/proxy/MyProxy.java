package com.hao.spring.proxy;

import com.google.gson.Gson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <code>MyProxy</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/5/30
 * @version: 1.0
 */
public class MyProxy implements InvocationHandler {

    private Object target;

    private String name;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin================"
                + "bean 名称为【" + name + "】方法为【"
                + method.getName() + "】========="
                + target.getClass()+ "====="
                + "参数args:"+new Gson().toJson(args));
        return method.invoke(target,args);
    }

    public void printDetail(){
        System.out.println("print detail.");
    }
}
