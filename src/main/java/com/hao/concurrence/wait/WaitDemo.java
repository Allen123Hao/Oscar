package com.hao.concurrence.wait;

import com.hao.concurrence.threadlocal.ThreadLocalTest;

/**
 * <code>WaitDemo</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/3/30
 * @version: 1.0
 */
public class WaitDemo {

    class MyThread1 extends Thread{
        public MyThread1(String name){
            super(name);
        }

        public void run(){
//            System.out.println("interrupted1:"+Thread.interrupted());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            System.out.println("interrupted2:"+Thread.interrupted());
            System.out.println(Thread.currentThread().getName()+" start running.");
            synchronized (this){
                System.out.println(Thread.currentThread().getName()+" call notify()");
                // 唤醒当前的wait线程
                this.notify();
                try {
                    this.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" end");
            }
        }
    }

    public static void main(String[] args) {
        MyThread1 t1 = new WaitDemo().new MyThread1("t1");
        synchronized (t1){
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName()+" start t1");
                t1.start();

                t1.interrupt();

                // 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName()+" wait()");
                t1.wait();

                System.out.println(Thread.currentThread().getName()+" continue");

                Thread.sleep(3000);

//                while("abc".endsWith("c")){
//
//                }

                System.out.println(Thread.currentThread().getName()+" end");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
