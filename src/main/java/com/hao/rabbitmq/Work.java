package com.hao.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * <code>Work</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/29
 * @version: 1.0
 */
public class Work {
    private final static String QUEUE_NAME = "workqueue";

    public static void main(String[] args) throws Exception{
        final int hashCode = Work.class.hashCode();
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        System.out.println(hashCode + " [*] Waiting for messages. To exit press CTRL+C");
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println(hashCode + " [x] Received '"+message+"'");
                try {
                    doWork(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(hashCode + "[x] Done");
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        boolean autoAck  = false;
        channel.basicConsume(QUEUE_NAME,autoAck ,consumer);
    }

    public static void doWork(String task) throws InterruptedException{
        for(char ch : task.toCharArray()){
            if(ch == '.'){
                Thread.sleep(1000);
            }
        }
    }
}
