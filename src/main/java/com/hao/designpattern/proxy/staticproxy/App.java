package com.hao.designpattern.proxy.staticproxy;

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
        ICompany company = new AppleCompany();
        AmazonCompany amazonCompany = new AmazonCompany(company);
        amazonCompany.doSomething();
    }
}
