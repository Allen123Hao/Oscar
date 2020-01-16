package com.hao.concurrence.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <code>BlockQueueTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/8
 * @version: 1.0
 */
public class BlockQueueTest {
    public class Basket{
        BlockingQueue<String> basket = new LinkedBlockingQueue<String>();

        public void produce() throws InterruptedException{
            basket.put("An apple");
        }
        public String consume() throws InterruptedException{
            return basket.take();
        }
    }

    class Producer implements Runnable{
        private String instance;
        private Basket basket;

        Producer(String instance,Basket basket){
            this.instance = instance;
            this.basket = basket;
        }

        @Override
        public void run() {
            try {
                while(true){
                    System.out.println("生产者准备生产苹果："+instance);
                    basket.produce();
                    System.out.println("生产者生产苹果完毕" + instance);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                System.out.println("Producer Interrupted");
            }
        }
    }
    class Customer implements Runnable{
        private String instance;
        private Basket basket;

        Customer(String instance,Basket basket){
            this.instance = instance;
            this.basket = basket;
        }
        @Override
        public void run() {
            try {
                while(true){
                    System.out.println("消费者准备消费苹果："+instance);
                    basket.consume();
                    System.out.println("消费者消费苹果完毕" + instance);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Customer Interrupted");
            }
        }
    }

    public static void main(String[] args){
        BlockQueueTest test = new BlockQueueTest();
        Basket basket = test.new Basket();

        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer1 = test.new Producer("生产者01",basket);
        Producer producer2 = test.new Producer("生产者02",basket);
        Customer customer = test.new Customer("消费者01",basket);
        service.submit(producer1);
        service.submit(producer2);
        service.submit(customer);
    }
}
