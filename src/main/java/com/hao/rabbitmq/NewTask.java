package com.hao.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * <code>NewTask</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/29
 * @version: 1.0
 */
public class NewTask {
    private final static String QUEUE_NAME = "workqueue";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //注：RabbitMQ不允许使用不同的参数重新定义一个队列，所以已经存在的队列，我们无法修改其属性
        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME,durable,false,false,null);
        for(int i=0;i<10;i++){
            String dots = "";
            for(int j=0;j<=i;j++){
                dots += ".";
            }
            String message = "helloworld"+dots+dots.length();
            channel.basicPublish("",QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
            System.out.println("[x] Send '"+message+"'");
        }
        channel.close();
        connection.close();
    }
}
