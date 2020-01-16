package com.hao.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Random;
import java.util.UUID;

/**
 * <code>EmitLogDirect</code>
 *
 * @description: 发送消息时可以设置routing_key，接收队列与转发器间可以设置binding_key，
 * 接收者接收binding_key与routing_key相同的消息。
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/30
 * @version: 1.0
 */
public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "ex_logs_direct";
    private static final String[] SEVERITIES = {"info","warning","error"};

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 声明direct类型转发器
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        for(int i=0;i<6;i++){
            String severity = getSeverity();
            String message = severity+"_log:"+ UUID.randomUUID().toString();
            // 发布消息至转发器，指定routingkey
            channel.basicPublish(EXCHANGE_NAME,severity,null,message.getBytes());
            System.out.println("[x] Send '"+message+"'");
        }
        channel.close();
        connection.close();

    }

    /**
     * 随机产生一种日志类型
     * @return
     */
    private static String getSeverity(){
        Random random = new Random();
        int val = random.nextInt(3);
        return SEVERITIES[val];
    }
}
