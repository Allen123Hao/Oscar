package com.hao.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <code>ThreadPoolExecutorTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-07-29
 * @version: 1.0
 */
public class ThreadPoolExecutorTest {


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
    }


    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+System.currentTimeMillis());
            }
        }
    }
}
