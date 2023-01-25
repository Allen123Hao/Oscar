package com.hao.concurrence.demo;

/**
 * <code>DemoTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2022-12-05
 * @version: 1.0
 */
public class DemoTest {

    public static void main(String[] args) {
        //守护线程测试
//        DemoTest.demoThreadTest();
        DemoTest.interruptedTest();

    }

    public static void demoThreadTest(){
        System.out.println("main begin");
        Thread t = new Thread(()->{
            System.out.println("t begin");

            int flag = 0;
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(++flag);
            }
            System.out.println("t end");
        });
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }

    public static void interruptedTest(){
        System.out.println("main begin");
        Thread t = new Thread(()->{
            System.out.println("t begin");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t end");
        });
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1"+t.isInterrupted());
        t.interrupt();
        System.out.println("t2"+t.isInterrupted());
        System.out.println("main end");
    }
}
