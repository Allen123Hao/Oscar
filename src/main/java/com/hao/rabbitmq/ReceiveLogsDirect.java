package com.hao.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * <code>ReceiveLogsDirect</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/30
 * @version: 1.0
 */
public class ReceiveLogsDirect {
    private static final String EXCHANGE_NAME = "ex_logs_direct";
    private static final String[] SEVERRITIES = {"info","warning","error"};

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 声明direct类型转发器
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");

        String queueName = channel.queueDeclare().getQueue();
        String severity = getSeverity();
        // 使用绑定键（binding key）来创建一个绑定
        channel.queueBind(queueName, EXCHANGE_NAME, severity);
        System.out.println(" [*] Waiting for " + severity + " logs. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(queueName,true,consumer);

    }

    /**
     * 随机产生一种日志类型
     * @return
     */
    private static String getSeverity(){
        Random random = new Random();
        int val = random.nextInt(3);
        return SEVERRITIES[val];
    }


}
