package com.hao.nio;

import io.netty.buffer.ByteBuf;
import org.apache.ibatis.annotations.SelectKey;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * <code>SelectorTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-18
 * @version: 1.0
 */
public class SelectorTest {

    public void server(){
        try {
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.socket().setReuseAddress(true);
            serverChannel.socket().bind(new InetSocketAddress(8080));
            Selector selector = Selector.open();
            SelectionKey selectionKey = serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println(selectionKey.interestOps());
            System.out.println(selectionKey.readyOps());
            while(true){
                int n = selector.select();
                if(n==0){
                    continue;
                }
                Iterator iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = (SelectionKey) iterator.next();
                    if(key.isAcceptable()){
                        System.out.println("SelectionKey isAcceptable");
                        SocketChannel socketChannel = ((ServerSocketChannel)(key.channel())).accept();
//                        socketChannel.configureBlocking(false);
//                        socketChannel.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(512));
                        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
                        int size;
                        while((size = socketChannel.read(byteBuffer)) != -1){
                            System.out.println("in size:"+size);
                            byteBuffer.flip();
                            while (byteBuffer.hasRemaining()){
                                System.out.println(byteBuffer.get());
                            }
                            System.out.println("继续读");
                            byteBuffer.clear();
                        }
                        System.out.println("out size:"+size);
                        System.out.println("Over!!!");

                    }
                    if(key.isReadable()){
                        System.out.println("SelectionKey isReadable");
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
                        while((socketChannel.read(byteBuffer)) != -1){
                            byteBuffer.flip();
                            while(byteBuffer.hasRemaining()){
                                System.out.println(byteBuffer.get());
                            }
                        }
                        System.out.println("Over!!!");
//                        handleRead(key);
                    }
                    if(key.isWritable() && key.isValid()){
                        System.out.println("SelectionKey isWritable");
//                        handleWrite(key);
                    }
                    if(key.isConnectable()){
                        System.out.println("isConnectable = true");
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void client() throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
//        socketChannel.configureBlocking(false);
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
        byte[] bytes = str.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
//        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
//        ByteBuffer byteBuffer1 = ByteBuffer.allocate(20);
//        socketChannel.read(byteBuffer1);
//        byteBuffer1.flip();
//        while (byteBuffer1.hasRemaining()){
//            System.out.println((char)byteBuffer1.get());
//        }
        socketChannel.shutdownOutput();
        socketChannel.close();
    }

    public static void main(String[] args) throws Exception{
        SelectorTest selectorTest = new SelectorTest();
        selectorTest.server();
    }
}
