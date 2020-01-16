package com.hao.rabbitmq;

import com.rabbitmq.client.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <code>ReceiveLogsToSave</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/29
 * @version: 1.0
 */
public class ReceiveLogsToSave {
    private final static String EXCHANGE_NAME = "ex_log";

    public static void main(String[] args) throws Exception{
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
                print2File(message);
            }
        };
        // 指定接收者，第二个参数为自动应答，无需手动应答
        channel.basicConsume(queueName,true,consumer);
    }

    private static void print2File(String msg){
        String dir = ReceiveLogsToSave.class.getClassLoader().getResource("").getPath();
        System.out.println("dir:"+dir);
        String logFileName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println("logFileName:"+logFileName);
        File file = new File(dir,logFileName+".txt");
        try {
            FileOutputStream fos = new FileOutputStream(file,true);
            fos.write((msg + "\r\n").getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
