package com.hao.thread;

/**
 * <code>DaemonTest</code>
 *
 * @description: 主线程完成，守护线程也完成
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-07-13
 * @version: 1.0
 */
public class DaemonTest {

    public void test1(){
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("hi Daemon....");
                }
            }
        }
        );
        daemonThread.setDaemon(true);
        daemonThread.start();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread is over!");
    }

    public void test2(){
        Thread t = new Thread(()->{
            Thread daemonThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("hi Daemon....");
                    }
                }
            }
            );
            daemonThread.setDaemon(true);
            daemonThread.start();

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1 is over!");

        },"线程1");
        t.start();
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread is over!");
    }


    public static void main(String[] args) {
        DaemonTest test = new DaemonTest();
        test.test2();
    }
}

