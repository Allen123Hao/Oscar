package com.hao.annotation;

/**
 * <code>SayHello</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/7/3
 * @version: 1.0
 */
@RPCService(value = SayHello.class)
public class SayHello implements ISayHello{

    @Override
    public void say(String name) {
        System.out.println("Hello "+name);
    }
}
