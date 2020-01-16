package com.hao.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * <code>ReceiveLogsTopicForKernal</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/31
 * @version: 1.0
 */
public class ReceiveLogsTopicForKernal {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws Exception {
        // 创建连接和频道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 声明转发器
        channel.exchangeDeclare(EXCHANGE_NAME,"topic");
        // 随机生成一个队列
        String queueName = channel.queueDeclare().getQueue();
        //接收所有与kernel相关的消息
        channel.queueBind(queueName, EXCHANGE_NAME, "kernal.*");

        System.out.println(" [*] Waiting for messages about kernel. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                String routingKey = envelope.getRoutingKey();
                System.out.println(" [x] Received routingKey = " + routingKey
                        + ",msg = " + message + ".");
            }
        };
        channel.basicConsume(queueName,true,consumer);

    }
}
