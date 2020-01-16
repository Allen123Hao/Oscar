package com.hao.concurrence.demo;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * <code>HookTest1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/5
 * @version: 1.0
 */
public class HookTest1 {
//    private ExecutorService executor = Executors.newCachedThreadPool();
//
//
//    {
//        System.out.println("inner block");
//        Runtime.getRuntime().addShutdownHook(new Thread(){
//            @Override
//            public void run(){
//                System.out.println("before shutdown");
//                executor.shutdown();
//                System.out.println("after shutdown");
//                try {
//                    System.out.println("before awaitTermination");
//                    executor.awaitTermination(1, TimeUnit.MINUTES);
//                    System.out.println("after awaitTermination");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }


//    public void execute(MyTask task){
//        executor.execute(task);
//    }
    public static void main(String[] args){
        HookTest1 test = new HookTest1();
        Map<String,String> map = new HashMap<String,String>();
        for(int i=0;i<10;i++){
//            test.execute(new HookTest.MyTask(test));
            new Thread(new MyTask(test)).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("map info...");

        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
//        System.exit(0);
    }

    static class MyTask implements Runnable{
        private HookTest1 hookTest;
        public MyTask(HookTest1 test){
            this.hookTest = test;
        }

        @Override
        public void run(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread name:"+Thread.currentThread().getName());
            Thread t = Thread.currentThread();
            RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
            String name = ManagementFactory.getRuntimeMXBean().getName();
            System.out.println("name:"+name);
        }
    }
}
