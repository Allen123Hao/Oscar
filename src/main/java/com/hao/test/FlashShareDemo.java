package com.hao.test;

/**
 * <code>FlashShareDemo</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-06-16
 * @version: 1.0
 */
public class FlashShareDemo {

    //测试对象，对象头占8字节，声明一个long类型8字节，
    //共16字节，连续声明4个demo对象，多半在同一个缓存行中
    static class Demo{

        //需要操作的对象声明为volatile以便其他线程可以看到其变化
        public volatile long value = 0L;

        //填充long，每个8字节，填充6个，共64字节，刚好一个缓存行
        private long P1,P2,P3,P4,P5,P6;

    }

    //启动线程对demo中的value值做大量存取操作
    static final class TestThread extends Thread{

        private Demo demo;

        public TestThread(final Demo demo){
            this.demo = demo;
        }

        @Override
        public void run(){

            long start = System.currentTimeMillis();

            for(int i = 0 ; i < 100000000; i++){
                demo.value = i;
            }

            start = System.currentTimeMillis() - start;

            System.out.println(Thread.currentThread().getName() + "运行耗时" + start);
        }

    }


    public static void main(String[] args) throws Exception{

        Demo[] Demo = new Demo[4];

        //启动四个线程进行测试
        for(int i = 0; i < 4; i++){
            Demo[i] = new Demo();
        }

        TestThread[] testThread = new TestThread[Demo.length];

        for (int i = 0; i < Demo.length ; i++ ){
            testThread[i] = new TestThread(Demo[i]);
        }

        long start = System.currentTimeMillis();

        for(Thread t : testThread){
            t.start();
        }

        for(Thread t : testThread){
            t.join();
        }

        start = System.currentTimeMillis() - start;

        System.out.println("未填充对象访问耗时：" + start);
    }
}
