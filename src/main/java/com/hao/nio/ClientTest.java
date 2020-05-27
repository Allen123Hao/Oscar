package com.hao.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
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
        socketChannel.connect(new InetSocketAddress(8080));
        if(socketChannel.finishConnect()){
            System.out.println("finishConnect");
        }
        while(!socketChannel.isConnected()){
            System.out.println("connecting");
            Thread.sleep(3000);
        }
        System.out.println("connected...");
        String str = "Hello World";
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
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

    public static void main(String[] args) {

    }
}
