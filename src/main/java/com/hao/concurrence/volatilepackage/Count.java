package com.hao.concurrence.volatilepackage;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <code>Count</code>
 *
 * @description:
 * 在 java 垃圾回收整理一文中，描述了jvm运行时刻内存的分配。其中有一个内存区域是jvm虚拟机栈，
 * 每一个线程运行时都有一个线程栈，线程栈保存了线程运行时候变量值信息。当线程访问某一个对象时候
 * 值的时候，首先通过对象的引用找到对应在堆内存的变量的值，然后把堆内存变量的具体值load到线程
 * 本地内存中，建立一个变量副本，之后线程就不再和对象在堆内存变量值有任何关系，而是直接修改副本
 * 变量的值，在修改完之后的某一个时刻（线程退出之前），自动把线程变量副本的值回写到对象在堆中变量。
 * 这样在堆中的对象的值就产生变化了。
 *
 * 对于volatile修饰的变量，jvm虚拟机只是保证从主内存加载到线程工作内存的值是最新的
 * 参考https://www.cnblogs.com/Free-Thinker/p/6651299.html?utm_source=itdadao&utm_medium=referral
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/2
 * @version: 1.0
 */
public class Count {
    public static volatile int count = 0;

//    public static AtomicInteger count1 = new AtomicInteger(0);
    public static void inc(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        count++;
        count = count + 1;
//        count1.addAndGet(1);
    }
    public static void main(String[] args){
        for(int i=0;i<1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Count.inc();
                }
            }).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count:"+Count.count);
//        System.out.println("count1:"+Count.count1);
    }
}
