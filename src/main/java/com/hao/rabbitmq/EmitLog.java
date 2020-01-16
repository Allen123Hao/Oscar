package com.hao.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * <code>EmitLog</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/29
 * @version: 1.0
 */
public class EmitLog {
    private final static String EXCHANGE_NAME = "ex_log";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 声明转发器和类型
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String message = DateFormat.getDateInstance().format(new Date()) + " : log something";
        // 往转发器上发送消息
        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println("[x] Send '"+message+"'");
        channel.close();
        connection.close();


    }
}
