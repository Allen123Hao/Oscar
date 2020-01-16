package com.hao.concurrence.timeout;

import java.util.concurrent.TimeoutException;

/**
 * <code>TimeoutByJoin</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/6/21
 * @version: 1.0
 */
public class TimeoutByJoin {

    public static void main(String[] args) {
        MyThread myThread = new MyThread(10);
        myThread.start();
        try {
            myThread.join(5000);
            if(myThread.isAlive()){
                System.out.println("myThread is alive.");
                myThread.interrupt();
                throw new TimeoutException();
            }
            System.out.println("result:"+myThread.getResult());
            System.out.println(myThread.isAlive());
            System.out.println(Thread.currentThread().isAlive());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (TimeoutException e){
            e.printStackTrace();
        }


    }
}

class MyThread extends Thread{
    private int time;
    private int result;

    public MyThread(int time){
        this.time = time;
    }
    public int getResult() {
        return result;
    }

    @Override
    public void run(){
        int count = 0;
        while(count < time){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            result++;
        }
    }
}
