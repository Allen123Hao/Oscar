package com.hao.concurrence.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <code>Setup</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/8
 * @version: 1.0
 */
public class Setup {
    public static void main(String[] args){
        BlockingQueue queue = new LinkedBlockingQueue();
        Producer p = new Producer(queue);
        Customer c1 = new Customer(queue);
        Customer c2 = new Customer(queue);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}
