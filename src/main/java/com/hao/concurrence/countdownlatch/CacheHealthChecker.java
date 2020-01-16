package com.hao.concurrence.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * <code>CacheHealthChecker</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/5/25
 * @version: 1.0
 */
public class CacheHealthChecker extends BaseHealthChecker{

    public CacheHealthChecker(CountDownLatch latch){
        super("Cache service",latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
