package com.hao.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * <code>DatagramChannelTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-20
 * @version: 1.0
 */
public class DatagramChannelTest {

    public static void main(String[] args) {
        try {
            DatagramChannel datagramChannel = DatagramChannel.open();
            datagramChannel.socket().bind(new InetSocketAddress(8080));
            ByteBuffer buffer = ByteBuffer.allocate(10);
            buffer.clear();
            while(true){
                datagramChannel.receive(buffer);
                buffer.flip();
                while(buffer.hasRemaining()){
                    System.out.print((char)buffer.get());
                }
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
