package com.hao.concurrence.synchronize;

/**
 * <code>Solution_70</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/9/22
 * @version: 1.0
 */
public class Demo1 {

    protected Object lock;

    protected Demo1(){
        lock = this;
    }

    public static void countTime(){
        int count = 0;
        while(count < 5){
            System.out.println("计时:"+count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }

    }

    public void func0(){
        System.out.println("This is func0");
    }

    public synchronized void func1(){
        System.out.println("This is func1");
    }

    public synchronized void func2(){
        System.out.println("go into func2");
        System.out.println("This is func2 begin");
        countTime();
        System.out.println("This is func2 over");
    }

    public static synchronized void func3(){
        System.out.println("go into func3.");
        System.out.println("This is func3 begin");
        countTime();
        System.out.println("This is func3 over");
    }

    public void func4(){
        System.out.println("go into func4");
        synchronized (this){
            System.out.println("This is func4 begin");
            countTime();
            System.out.println("This is func4 over");
        }
    }

    public void func5(){
        System.out.println("go into func5");
        synchronized (lock){
            System.out.println("This is func5 begin");
            countTime();
            System.out.println("This is func5 over");
        }
    }

    public synchronized void func6(){
        System.out.println("go into func6");
        synchronized (Demo1.class){
            System.out.println("This is func6 begin");
            countTime();
            System.out.println("This is func6 over");
        }
    }

    public static void main(String[] args) {
        final Demo1 demo1 = new Demo1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Demo1 demo1_1 = new Demo1();
                demo1_1.func1();
                demo1_1.func6();
//                demo1.func0();
//                demo1.func1();
//                demo1.func2();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Demo1 demo1_2 = new Demo1();
                demo1_2.func1();
                demo1_2.func6();
//                demo1.func0();
//                demo1.func1();
//                demo1.func2();
            }
        }).start();


    }
}
