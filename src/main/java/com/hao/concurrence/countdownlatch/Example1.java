package com.hao.concurrence.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * <code>Example1</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-07-22
 * @version: 1.0
 */
public class Example1 {

    private CountDownLatch count = new CountDownLatch(2);

    private void func1(){
        Thread thread1 = new Thread(new MyRunnable(count));
        Thread thread2 = new Thread(new MyRunnable(count));
        thread1.start();
        thread2.start();

        for(int i=0;i<10;i++){
            if(i==5){
                try {
                    count.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i);
        }
    }

    class MyRunnable implements Runnable{
        private CountDownLatch count1;
        MyRunnable(CountDownLatch count){
            count1 = count;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000*20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            count1.countDown();
        }
    }

    public static void main(String[] args) {
        Example1 example1 = new Example1();
        example1.func1();
    }
}
