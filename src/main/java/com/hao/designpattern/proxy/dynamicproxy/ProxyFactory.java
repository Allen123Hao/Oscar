package com.hao.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <code>ProxyFactory</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/5/25
 * @version: 1.0
 */
/**
 * 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 */
public class ProxyFactory {
    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }
    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("进货了……");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target,args);
                        System.out.println("卖完了……");
                        return returnValue;
                    }
                }
        );
    }
}
