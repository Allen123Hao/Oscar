package com.hao.concurrence.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <code>CyclicBarrierTest1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019/1/1
 * @version: 1.0
 */
public class CyclicBarrierTest1 {
    private static int SIZE = 5;
    private static CyclicBarrier cb;
    public static void main(String[] args) {

        cb = new CyclicBarrier(SIZE, new Runnable () {
            public void run() {
                System.out.println("CyclicBarrier's parties is: "+ cb.getParties());
            }
        });

        // 新建5个任务
        for(int i=0; i<SIZE+2; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == SIZE){
                System.out.println("second...");
                cb = new CyclicBarrier(2, new Runnable () {
                    public void run() {
                        System.out.println("Second CyclicBarrier's parties is: "+ cb.getParties());
                    }
                });
            }
            new InnerThread().start();
        }

    }

    static class InnerThread extends Thread{
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");

                // 将cb的参与者数量加1
                cb.await();

                // cb的参与者数量等于5时，才继续往后执行
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
