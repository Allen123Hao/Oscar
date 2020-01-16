package com.hao.concurrence.blockingqueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <code>Demo1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/8
 * @version: 1.0
 */
public class Demo1 {

    private static ExecutorService service = Executors.newSingleThreadExecutor();

    private final BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>();


    public boolean addRequest(String req){
        try {
            Random random = new Random();
            int t = random.nextInt(5);
            System.out.println("等待"+t+"秒");
            Thread.sleep(t*1000);
            msgQueue.put(req);
            System.out.println("请求："+req+"加入队列。");
        } catch (InterruptedException e) {
            System.out.println("addRequest interrupt!");
            return false;
        }
        return true;
    }
    public void init(){

    }
    public void destroy(){

    }

    public void startTask(){
        MsgStatusRunnable runnable = new MsgStatusRunnable();
        service.submit(runnable);
        System.out.println("任务开启。。。");
    }

    class MsgStatusRunnable implements Runnable{
        @Override
        public void run() {
            while(true){
                try {
                    System.out.println("开始处理请求……");
                    String request = msgQueue.take();
                    System.out.println("接收到request:"+request);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        Demo1 demo1 = new Demo1();
        demo1.startTask();
        for(int i=0;i<50;i++){
            String req = "Requst"+String.valueOf(i);
            demo1.addRequest(req);
        }
    }

}
