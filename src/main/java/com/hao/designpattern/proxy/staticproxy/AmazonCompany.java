package com.hao.designpattern.proxy.staticproxy;

/**
 * <code>AmazonCompany</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/5/25
 * @version: 1.0
 */

/**
 * 代理对象，聚合式静态代理
 */
public class AmazonCompany implements ICompany {
    private ICompany target;
    public AmazonCompany(ICompany target){
        this.target = target;
    }
    @Override
    public void doSomething() {
        System.out.println("进货了……");
        target.doSomething();
        System.out.println("卖完了……");
    }
}

/**
 * 继承式静态代理
 */
/**
public class AmazonCompany extends AppleCompany1{

    @Override
    public void doSomething() {
        System.out.println("进货了……");
        super.doSomething();
        System.out.println("卖完了……");
    }
}
 */


