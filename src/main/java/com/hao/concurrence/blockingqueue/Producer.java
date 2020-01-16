package com.hao.concurrence.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * <code>Producer</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/8
 * @version: 1.0
 */
public class Producer implements Runnable{
    private final BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                queue.put(produce());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    Object produce(){
        return null;
    }
}
