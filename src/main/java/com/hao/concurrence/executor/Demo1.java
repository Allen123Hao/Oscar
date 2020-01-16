package com.hao.concurrence.executor;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <code>Demo1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/7
 * @version: 1.0
 */
public class Demo1 {
    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.out.println("shutdown");
                executorService.shutdown();
                try {
                    executorService.awaitTermination(1, TimeUnit.MINUTES);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void fun1(int i,Runnable task){
        System.out.println("name:"+Thread.currentThread().getName());
        System.out.println("before:"+i);
        executorService.execute(task);
        System.out.println("after:"+i);
    }
    public static void main(String[] args){
        Demo1 demo1 = new Demo1();
        boolean flag = true;
        for(int i=0;i<5;i++){
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            demo1.fun1(i,new MyThread());
            if(flag){
                new Thread(){
                    public void run(){
                        System.out.println("close");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.exit(0);
                    }
                }.start();
                flag = false;
            }

            if(i>2){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            demo1.executorService.execute(new MyThread());
            System.out.println("I:" + i);
        }
    }
    static class MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread()+"开始等待");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"结束等待");
            System.out.println(new Date().getTime());
        }
    }
}
