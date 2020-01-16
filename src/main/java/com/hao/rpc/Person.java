package com.hao.rpc;

/**
 * <code>Person</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/16
 * @version: 1.0
 */
public interface Person {
    public int getAge() throws Throwable;
    public String getName() throws Throwable;
}
