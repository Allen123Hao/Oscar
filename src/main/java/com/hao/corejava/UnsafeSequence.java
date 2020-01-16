package com.hao.corejava;

/**
 * <code>UnsafeSequence</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/1
 * @version: 1.0
 */
public class UnsafeSequence {
    private int value;
    public int getNext(){
        return value++;
    }
    public static void main(String[] args){
        UnsafeSequence unsafeSequence = new UnsafeSequence();
//        MyThread thread1 = new MyThread(unsafeSequence);
//        MyThread thread2 = new MyThread(unsafeSequence);
//        new Thread(thread1).start();
//        new Thread(thread2).start();
        for(int i=0;i<1000;i++){
            MyThread thread = new MyThread(unsafeSequence);
            new Thread(thread).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(unsafeSequence.value);
    }
}

class MyThread implements Runnable{
    private UnsafeSequence unsafeSequence;
    public MyThread(UnsafeSequence unsafeSequence){
        this.unsafeSequence = unsafeSequence;
    }
    public void run() {
        unsafeSequence.getNext();
    }
}
