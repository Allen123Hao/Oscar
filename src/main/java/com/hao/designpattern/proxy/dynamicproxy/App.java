package com.hao.designpattern.proxy.dynamicproxy;

/**
 * <code>App</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/5/25
 * @version: 1.0
 */

/**
 * 测试类
 */
public class App {
    public static void main(String[] args) {
        // 目标对象
        ICompany target = new AppleCompany();
        System.out.println(target.getClass());
        // 给目标对象，创建代理对象
        ICompany proxy = (ICompany) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());
        // 执行方法   【代理对象】
        proxy.doSomething();
    }
}
