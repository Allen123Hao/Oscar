package com.hao.concurrence.forkjoin;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <code>Solution_70</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/1/9
 * @version: 1.0
 */
public class Demo1 {

    public static void main(String[] args) {

        System.out.println("========="+Counter.addOne1());
        System.out.println("========="+Counter.addOne1());

        for(int i=0;i<100;i++){
            Thread thread = new Thread(){
                @Override
                public void run(){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(Counter.addOne() == 100){
                        System.out.println("counter==100");
                    }
                    if(Counter.addOne1() == 100){
                        System.out.println("counter1==100");
                    }
//                    System.out.println("===count:"+Counter.addOne());
//                    System.out.println("***count1:"+Counter.addOne1());
                }
            };
            thread.start();
        }
    }
}

class Counter{
    private static int count = 0;

    private static AtomicInteger count1 = new AtomicInteger();

    protected static int addOne(){
        return ++count;
    }

    protected static int addOne1(){
//        return count1.incrementAndGet();
//        return count1.addAndGet(1);
        return count1.getAndIncrement();
    }
}
