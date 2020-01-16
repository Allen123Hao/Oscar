package com.hao.concurrence.threadlocal;

/**
 * <code>ThreadLocalTest1</code>
 *
 * @description: ThreadLocal不是用来解决共享变量问题的，它与多线程的并发问题没有任何关系
 * 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，所以
 * 每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/4/24
 * @version: 1.0
 */
public class ThreadLocalTest1 {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set()
    {
        longLocal.set(1L);
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong()
    {
        return longLocal.get();
    }

    public String getString()
    {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException
    {
        final ThreadLocalTest1 test = new ThreadLocalTest1();

        test.set();     // 初始化ThreadLocal
        for (int i=0; i<10; i++)
        {
            System.out.println(test.getString() + " : " + test.getLong() + i);
        }

        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                for (int i=0; i<10; i++)
                {
                    System.out.println(test.getString() + " : " + test.getLong() + i);
                }
            };
        };
        thread1.start();

        Thread thread2 = new Thread(){
            public void run() {
                test.set();
                for (int i=0; i<10; i++)
                {
                    System.out.println(test.getString() + " : " + test.getLong() + i);
                }
            };
        };
        thread2.start();
    }
}
