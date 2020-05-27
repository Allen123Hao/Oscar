package com.hao.jvm.thread;

import org.apache.lucene.util.RamUsageEstimator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <code>TestThread</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-02
 * @version: 1.0
 */
public class TestThread {

    private static final int _1MB = 1024*1024;

    int count=0;


    public static void showClassType(){
        System.out.println(byte[].class.getName());
        System.out.println(String[].class.getName());
        System.out.println(int[].class.getName());
        System.out.println(double[].class.getName());
        System.out.println(Double.class.getName());
        System.out.println(float[].class.getName());
        System.out.println(char[].class.getName());
        System.out.println(Object[].class.getName());
        System.out.println(long.class.getName());
        System.out.println(Long[].class.getName());
    }

    public void runThread(){
//        byte[] alloc = new byte[_1MB * 6];
        ThreadInfo info = new ThreadInfo();

        for(int i=0;i<5;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    count++;
                    System.out.println(Thread.currentThread().getName());
                    info.setName(Thread.currentThread().getName()+"测试");
//                byte[] alloc = new byte[_1MB * 5];
                    System.out.println("before:"+info.getBytes().length);
                    try {
                        Thread.sleep(1000*200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("after:"+info.getBytes().length);
                    System.out.println(info.getName());
                    System.out.println(Thread.currentThread().getName()+" over");
                }
            });
            thread.start();
        }
    }

    /**
     * 先定义alloc后给ThreadInfo对象赋值，堆内存不会增加，
     * 如果ThreadInfo的bytes存在默认值，每new一个对象都会增加堆内存
     */
    public void func1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());
        byte[] alloc = new byte[_1MB];
        System.out.println("1:"+scanner.next());
        ThreadInfo info1 = new ThreadInfo();
        System.out.println("2:"+scanner.next());
        info1.setBytes(alloc);
        System.out.println("3:"+scanner.next());
        ThreadInfo info2 = new ThreadInfo();
        System.out.println("4:"+scanner.next());
        info2.setBytes(alloc);
        System.out.println(RamUsageEstimator.shallowSizeOf(info1));
        System.out.println(RamUsageEstimator.shallowSizeOf(info2));
        System.out.println("5:"+scanner.next());
        alloc = new byte[1024*1];
        System.out.println("6:"+scanner.next());
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
//        testThread.runThread();
//        TestThread.showClassType();
        testThread.func1();

    }
}
