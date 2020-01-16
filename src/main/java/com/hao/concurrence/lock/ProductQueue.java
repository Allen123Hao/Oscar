package com.hao.concurrence.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <code>ProductQueue</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/15
 * @version: 1.0
 */
public class ProductQueue<T> {
    private final T[] items;
    private final Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private int head,tail,count;
    public ProductQueue(int maxSize){
        items = (T[])new Object[maxSize];
    }
    public ProductQueue(){
        this(10);
    }
    public void put(T t) throws InterruptedException{
        lock.lock();
        try {
            while(count == getCapacity()){
                notFull.await();
            }
            items[tail] = t;
            System.out.println("生产了item["+tail+"]:"+t);
            if(++tail == getCapacity()){
                tail = 0;
            }
            ++count;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public T take() throws InterruptedException{
        lock.lock();
        try {
            while(count == 0){
                notEmpty.await();
            }
            T ret = items[head];
            items[head]  = null;
            System.out.println("消费了items["+head+"]:"+ret);
            if(++head == getCapacity()){
                head = 0;
            }
            --count;
            notFull.signalAll();
            return ret;
        } finally {
            lock.unlock();
        }
    }
    public int getCapacity(){
        return items.length;
    }
    public int size(){
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ProductQueue<String> products = new ProductQueue<String>(5);
        Thread thread1 = new Thread(new Productor(products));
        thread1.setName("生产者");
        Thread thread2 = new Thread(new Consumer(products));
        thread2.setName("消费者");
        thread1.start();
        thread2.start();

    }
}
class Productor implements Runnable{
    private ProductQueue<String> products;
    Productor(ProductQueue productQueue){
        this.products = productQueue;
    }
    @Override
    public void run() {
        try {
            products.put("apple");
            Thread.sleep(1000);
            products.put("pear");
            Thread.sleep(1000);
            products.put("banana");
            Thread.sleep(1000);
            products.put("peach");
            Thread.sleep(1000);
            products.put("watermelon");
            Thread.sleep(1000);
            products.put("orange");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Consumer implements Runnable{
    private ProductQueue<String> products;
    Consumer(ProductQueue<String> productQueue){
        this.products = productQueue;
    }
    public void run(){
        try {
            while(true){
//                Thread.sleep(2000);
                products.take();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
