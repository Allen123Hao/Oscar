package com.hao.threadpool;

import java.util.concurrent.*;

/**
 * <code>ThreadPoolExecutorTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-07-29
 * @version: 1.0
 */
public class ThreadPoolExecutorTest {

    public void test1(){
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
    }

    public void test2(){
        ExecutorService service = new ThreadPoolExecutor(3,3,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(1));
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
    }


    public static void main(String[] args) {
        ThreadPoolExecutorTest executorTest = new ThreadPoolExecutorTest();
        executorTest.test2();
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
