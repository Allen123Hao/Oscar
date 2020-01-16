package com.hao.designpattern.proxy.dynamicproxy;

/**
 * <code>AppleCompany</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/5/25
 * @version: 1.0
 */

/**
 * 接口实现，目标对象
 */
public class AppleCompany implements ICompany {
    @Override
    public void doSomething() {
        System.out.println("we cell iphones!");
    }
}
