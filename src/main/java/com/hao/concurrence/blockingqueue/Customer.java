package com.hao.concurrence.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * <code>Customer</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/8
 * @version: 1.0
 */
public class Customer implements Runnable{
    private final BlockingQueue queue;

    public Customer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                consume(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    void consume(Object x){

    }
}
