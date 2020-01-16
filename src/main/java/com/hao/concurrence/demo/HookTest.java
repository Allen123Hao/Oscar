package com.hao.concurrence.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * <code>HookTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/5
 * @version: 1.0
 */
public class HookTest {
    private ExecutorService executor = Executors.newCachedThreadPool();
    public HookTest(){
        System.out.println("HookTest Construct");
    }
    static {
        System.out.println("static inner block");
    }

    {
        System.out.println("inner block");
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.out.println("before shutdown");
                executor.shutdown();
                System.out.println("after shutdown");
                try {
                    System.out.println("before awaitTermination");
//                    Thread.sleep(6000);
                    executor.awaitTermination(1, TimeUnit.MINUTES);
                    System.out.println("after awaitTermination");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public Future<String> execute(MyTask task){
        return executor.submit(task);
    }
    public static void main(String[] args){
        HookTest test = new HookTest();
        Map<String,String> map = new HashMap<String,String>();
        for(int i=0;i<10;i++){
            MyTask task = new MyTask(test);
            Future<String> future = test.execute(task);
            try {
                String res = future.get();
                String name = res.split("-")[0];
                String value = res.split("-")[1];
                map.put(name,value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("map info...");
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.exit(0);
    }

    static class MyTask implements Callable<String>{
        private HookTest hookTest;
        public MyTask(HookTest test){
            this.hookTest = test;
        }

        @Override
        public String call() throws Exception {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread name:"+Thread.currentThread().getName());
            return Thread.currentThread().getName()+"-XYZ";
        }
    }
}
