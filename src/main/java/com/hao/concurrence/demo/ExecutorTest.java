package com.hao.concurrence.demo;

import java.util.List;
import java.util.concurrent.*;

/**
 * <code>ExecutorTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/6/5
 * @version: 1.0
 */
public class ExecutorTest {

    private static volatile boolean flag = true;

    private static LinkedBlockingQueue queue = new LinkedBlockingQueue(3);

//    private static ArrayBlockingQueue queue = new ArrayBlockingQueue(3);

    private static RejectedExecutionHandler defaultHandler = new ThreadPoolExecutor.AbortPolicy();

    private static ThreadPoolExecutor service = new ThreadPoolExecutor(2,6,0L,TimeUnit.MILLISECONDS,queue,defaultHandler);


    public static ExecutorService getService(){
        return service;
    }

    public static void main(String[] args) {
        for(int i=1;i<=13;i++){
            MyThread thread = new MyThread();
            System.out.println("添加线程:"+i);
            try {
                service.submit(thread);
            } catch (Exception e) {
                e.printStackTrace();
                flag = false;
                System.out.println("flag:"+flag);

            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread implements Runnable{

        private int count = 0;


        @Override
        public void run() {
            while(flag){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                String name = Thread.currentThread().getName();
                System.out.println(name+",count:"+count);
                System.out.println(name+",activeCount:"+service.getActiveCount());
                System.out.println(name+",poolSize:"+service.getPoolSize());
                System.out.println(name+",remainingCapacity:"+service.getQueue().remainingCapacity());
                System.out.println(name+",flag:"+flag);
                System.out.println("======");
            }
        }
    }
}
