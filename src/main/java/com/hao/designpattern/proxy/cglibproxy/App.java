package com.hao.designpattern.proxy.cglibproxy;

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
        AppleCompany target = new AppleCompany();
        // 代理对象
        AppleCompany proxy = (AppleCompany) new ProxyFactory(target).getProxyInstance();
        // 执行方法   【代理对象】
        proxy.doSomething();
    }
}
