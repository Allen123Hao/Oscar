package com.hao.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * <code>ReceiveLogsTopicForCritical</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/31
 * @version: 1.0
 */
public class ReceiveLogsTopicForCritical {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "*.critical");
        System.out.println(" [*] Waiting for critical messages. To exit press CTRL+C");

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
