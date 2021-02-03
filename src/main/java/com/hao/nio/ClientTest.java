package com.hao.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SocketChannel;

/**
 * <code>ClientTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-20
 * @version: 1.0
 */
public class ClientTest {

    public void testSocketChannel() throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress(17765));
        if(socketChannel.finishConnect()){
            System.out.println("finishConnect");
        }
        while(!socketChannel.isConnected()){
            System.out.println("connecting");
            Thread.sleep(3000);
        }
        System.out.println("connected...");
//        String str = "Hello World";
//        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
//        socketChannel.write(byteBuffer);
//        byte[] bytes = {72,101,108,108,111};
        byte[] bytes = {18, 17, 13, 10,9,1,62,0,0,0,1,0,0,0,1,2,0,6,1,72,101,108,108,111,9,10,13,17,18};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        socketChannel.write(byteBuffer);
        socketChannel.shutdownOutput();
        socketChannel.close();
    }

    public void testDatagramChannel(){
        try {
            String data = "hello kitty!!!";
            ByteBuffer buffer = ByteBuffer.allocate(20);
            buffer.clear();
            buffer.put(data.getBytes());
            buffer.flip();
            DatagramChannel channel = DatagramChannel.open();
            channel.send(buffer,new InetSocketAddress("localhost",8080));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        String s = "Hello World";
        ByteBuffer buffer = ByteBuffer.wrap(s.getBytes());
        ByteOrder byteOrder = buffer.order();
        System.out.println(byteOrder);
        System.out.println();
        ByteBuffer buffer1 = ByteBuffer.wrap(s.getBytes()).order(ByteOrder.LITTLE_ENDIAN);
        while(buffer1.hasRemaining()){
            System.out.print(buffer1.get());
            System.out.print(" ");
        }
        System.out.println();
        ByteBuffer buffer2 = ByteBuffer.wrap(s.getBytes()).order(ByteOrder.BIG_ENDIAN);
        while(buffer2.hasRemaining()){
            System.out.print(buffer2.get());
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        ClientTest clientTest = new ClientTest();
        try {
            clientTest.testSocketChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
