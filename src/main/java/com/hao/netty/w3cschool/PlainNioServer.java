package com.hao.netty.w3cschool;

import io.netty.channel.ServerChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <code>PlainNioServer</code>
 *
 * @description: Asynchronous networking without Netty
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/4/12
 * @version: 1.0
 */
public class PlainNioServer {
    public void server(int port) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        ServerSocket ss = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        //1.绑定服务器到制定端口
        ss.bind(address);
        //2.打开 selector 处理 channel
        Selector selector = Selector.open();
        //3.注册 ServerSocket 到 ServerSocket ，并指定这是专门 接受 连接。
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("Hi,\r\n".getBytes());
        for(;;){
            System.out.println("=========");
            try {
                //4.等待新的事件来处理。这将阻塞，直到一个事件是传入。
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("select has exception.");
                break;
            }
            //5.从收到的所有事件中 获取 SelectionKey 实例。
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    System.out.println("key option====");
                    System.out.println("isAcceptable:"+(key.isAcceptable()?"acceptable":null));
                    System.out.println("isReadable:"+(key.isReadable()?"readable":null));
                    System.out.println("isWritable:"+(key.isWritable()?"writable":null));
                    //6.检查该事件是一个新的连接准备好接受。
                    if(key.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        //7.接受客户端，并用 selector 进行注册。
                        client.register(selector,SelectionKey.OP_WRITE | SelectionKey.OP_READ,msg.duplicate());
                        System.out.println("Accepted connection from " + client);
                    }
                    //8.检查 socket 是否准备好写数据。
                    if(key.isWritable()){
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        while(buffer.hasRemaining()){
                            //9.将数据写入到所连接的客户端。如果网络饱和，连接是可写的，那么这个循环将写入数据，直到该缓冲区是空的
                            if(client.write(buffer) == 0){
                                break;
                            }
                        }
                        //10.连接关闭
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        }


    }

    public static void main(String[] args) throws Exception {
//        Set<String> ss = new HashSet<>();
//        ss.add("abc");ss.add("efg");ss.add("mln");
//        Iterator<String> iterator = ss.iterator();
//        while(iterator.hasNext()){
//            System.out.println("before size:"+ss.size()+","+ss.toString());
//            System.out.println(iterator.next());
//            iterator.remove();
//            System.out.println("after size:"+ss.size()+","+ss.toString());
//        }
//        System.out.println(1 << 2);
//        System.out.println(1 << 0);
//        System.out.println(1<<2 | 1 << 0);

        PlainNioServer nioServer = new PlainNioServer();
        nioServer.server(8001);

    }
}
