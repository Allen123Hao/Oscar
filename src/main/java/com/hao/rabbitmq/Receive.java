package com.hao.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * <code>Receive</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/29
 * @version: 1.0
 */
public class Receive {
    //队列名称
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception{
        //打开连接和创建频道，与发送端一样
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        System.out.println("[*] Waiting for message.To exit press CTRL+C");

        //创建队列消费者
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("[x] Received '"+message+"'");
            }
        };
        //指定消费队列
        channel.basicConsume(QUEUE_NAME,true,consumer);
        channel.close();
        connection.close();
    }
}
