package com.hao.thread;

/**
 * <code>DaemonTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-07-13
 * @version: 1.0
 */
public class DaemonTest {
    public static void main(String[] args) {
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
}

