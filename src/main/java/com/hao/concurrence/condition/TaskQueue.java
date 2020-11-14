package com.hao.concurrence.condition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <code>TaskQueue</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-07-22
 * @version: 1.0
 */
public class TaskQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        try {
            queue.add(s);
            System.out.println("add task:"+s);
            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("唤醒");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("等待");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("释放等待");
            }
            String task = queue.remove();
            System.out.println("get task:"+task);
            return task;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TaskQueue queue = new TaskQueue();
        Thread thread1 = new Thread(new MyRunnable(queue,"生成"),"生产者");
        Thread thread2 = new Thread(new MyRunnable(queue,"减少"),"消费者");
        thread1.start();
        thread2.start();
    }

    static class MyRunnable implements Runnable{

        private String name;
        private TaskQueue taskQueue;

        MyRunnable(TaskQueue taskQueue,String name){
            this.taskQueue = taskQueue;
            this.name = name;
        }

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(name.equals("生成")){
                    taskQueue.addTask(name+i);
                }else{
                    taskQueue.getTask();
                }

            }
        }
    }
}
