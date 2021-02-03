package com.hao.proxy;

import com.hao.test.Product;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <code>ProxyService</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-12-16
 * @version: 1.0
 */
public class ProxyService implements InvocationHandler{

    private Object object;

    public ProxyService(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy before");
        method.invoke(object,args);
        System.out.println("proxy after");
        return null;
    }

    public static void main(String[] args) {
        IService service = new Service();
        ProxyService proxyService = new ProxyService(service);
//        IService proxy = (IService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
//                new Class[]{IService.class},proxyService);
        IService proxy = (IService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),proxyService);
        proxy.say();
    }
}
