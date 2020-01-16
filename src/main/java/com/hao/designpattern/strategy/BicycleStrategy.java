package com.hao.designpattern.strategy;

/**
 * <code>BicycleStrategy</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/1
 * @version: 1.0
 */
public class BicycleStrategy implements TravelStrategy{
    @Override
    public void travel() {
        System.out.println("travel by bicycle.");
    }
}
