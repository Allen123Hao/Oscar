package com.hao.corejava;

/**
 * <code>SynchronizedTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2019-11-04
 * @version: 1.0
 */
public class SynchronizedTest {

    public static synchronized void func1(){
        System.out.println("This is func1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void func2(){
        synchronized (SynchronizedTest.class){
            System.out.println("This is func2");
        }

    }

    public static void main(String[] args) {
        SynchronizedTest test1 = new SynchronizedTest();
        SynchronizedTest test2 = new SynchronizedTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test1.func1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test2.func2();
            }
        });
        t1.start();
        t2.start();
    }
}
