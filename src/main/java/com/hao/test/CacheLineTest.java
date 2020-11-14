package com.hao.test;

/**
 * <code>CacheLineTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-06-16
 * @version: 1.0
 */
public class CacheLineTest {

    static class Demo1{
        private long l1,l2,l3,l4,l5,l6,l7;
        private volatile long var = 0L;
//        private long p1,p2,p3,p4,p5,p6,p7;
    }

    static class MyRunnable implements Runnable{
        private String name;
        private Demo1 demo1;
        MyRunnable(String name,Demo1 demo1){
            this.name = name;
            this.demo1 = demo1;
        }
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            for(int i=0;i<100000000;i++){
                demo1.var = i;
            }
            long end = System.currentTimeMillis();
            System.out.println("线程"+name+":"+(end-start));
        }
    }

    public static void main(String[] args) {
        Demo1[] demo1s = new Demo1[4];

        //启动四个线程进行测试
        for(int i = 0; i < 4; i++){
            demo1s[i] = new Demo1();
        }
        Thread[] threads = new Thread[4];
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(new MyRunnable("thread-"+i,demo1s[i]));
        }
        long start = System.currentTimeMillis();
        for(Thread t : threads){
            t.start();
        }
        try {
            for(Thread t : threads){
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("主线程:"+(end-start));
    }

}
