package com.hao.concurrence.reentrantlock;

import com.hao.concurrence.threadlocal.ThreadLocalTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <code>Counter</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/5
 * @version: 1.0
 */
public class Counter{
    private Lock lock = new ReentrantLock();

    public void printer(){
        lock.lock();
        try{
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            printer1();
        }finally {
            lock.unlock();
        }

    }

    public void printer1(){
        lock.lock();
        try {
            for(int i=10;i<20;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        } finally {
            lock.unlock();
        }
    }
}
class MyThread extends Thread{
    private Counter counter;

    private Integer code;

    public MyThread(Counter counter,String name,Integer code){
        super(name);
        this.counter = counter;
        this.code = code;
    }
    @Override
    public void run(){
        if(this.code == 1){
            counter.printer();
        }else{
            counter.printer1();
        }

    }
}
class App{
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread thread1 = new MyThread(counter,"线程1",1);
        MyThread thread2 = new MyThread(counter,"线程2",2);

        thread1.start();
        thread2.start();
    }
}
