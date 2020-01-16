package com.hao.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * <code>ReceiveLogsToConsole</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/29
 * @version: 1.0
 */
public class ReceiveLogsToConsole {

    private final static String EXCHANGE_NAME = "ex_log";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        // 创建一个非持久的、唯一的且自动删除的队列
        String queueName = channel.queueDeclare().getQueue();
        System.out.println("queueName:"+queueName);
        // 为转发器指定队列，设置binding
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        // 指定接收者，第二个参数为自动应答，无需手动应答
        channel.basicConsume(queueName,true,consumer);
    }
}
