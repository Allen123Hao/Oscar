package com.hao.concurrence.countdownlatch.checkhealth;

import java.util.concurrent.CountDownLatch;

/**
 * <code>NetworkHealthChecker</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/5/25
 * @version: 1.0
 */
public class NetworkHealthChecker extends BaseHealthChecker{

    public NetworkHealthChecker(CountDownLatch latch){
        super("Network service",latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
