package com.hao.spring.proxy;

/**
 * <code>MyPrint</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/5/30
 * @version: 1.0
 */
public class MyPrint implements MyTarget {
    @Override
    public void print(String text) {
        System.out.println("打印:"+text);
    }
}
