package com.hao.designpattern.proxy.cglibproxy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <code>ProxyFactory</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/5/25
 * @version: 1.0
 */

/**
 * Cglib子类代理工厂
 * 对AppleCompany在内存中动态构建一个子类对象
 */
public class ProxyFactory implements MethodInterceptor{
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("进货了……");
        //执行目标对象方法
        Object returnValue = method.invoke(target,objects);
        System.out.println("卖完了……");
        return returnValue;
    }
}
