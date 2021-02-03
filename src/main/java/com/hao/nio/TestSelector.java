package com.hao.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <code>TestSelector</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-12-17
 * @version: 1.0
 */
public class TestSelector {
    private static Selector selector;

    public static void main(String[] args) throws IOException, InterruptedException {
        startSelectorThread();
        Thread.sleep(3000);
        System.out.println("新连接加入");
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress(8888));
        Thread.sleep(3000);
        System.out.println("唤醒");
        selector.wakeup();
    }

    private static void startSelectorThread(){
        Runnable selectorTask = () -> {
            try{
                String host = "127.0.0.1";
                int port = 8888;
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.configureBlocking(false);
                SocketAddress socketAddress = new InetSocketAddress(host, port);
                serverSocketChannel.bind(socketAddress);
                selector = Selector.open();
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                while(true){
                    System.out.println("selector start select .....");
                    int result = selector.select();
                    System.out.println("select result:"+result);
                    Set<SelectionKey> selectionKeySet =  selector.selectedKeys();
                    for(Iterator<SelectionKey> iterator = selectionKeySet.iterator(); iterator.hasNext(); ){
                        SelectionKey selectionKey = iterator.next();
                        System.out.println(selectionKey.readyOps());
//                        selectionKeySet.remove(selectionKey);
                        if(selectionKey.isAcceptable()){
                            ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();
                            SocketChannel clientChannel = serverSocketChannel1.accept();
                            clientChannel.configureBlocking(false);
                            clientChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        }else if(selectionKey.isReadable()){
                            SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(20);
                            int size;
                            while((size = socketChannel1.read(byteBuffer)) != -1){
                                System.out.println("in size:"+size);
                                byteBuffer.flip();
                                while (byteBuffer.hasRemaining()){
                                    System.out.println(byteBuffer.get());
                                }
                                System.out.println("继续读");
                                byteBuffer.clear();
                            }
                        }else if(selectionKey.isWritable()){
                            SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
                            String str = "Hello World";
                            byte[] bytes = str.getBytes();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
                            byteBuffer.put(str.getBytes());
                            byteBuffer.flip();
                            socketChannel1.write(byteBuffer);
                            socketChannel1.shutdownOutput();
                            socketChannel1.close();
                        }else if(selectionKey.isValid()){
                            System.out.println("inValid");
                        }
                        iterator.remove();
                    }

                    System.out.println("selector end select ....");
                    Thread.sleep(1000);

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }; //task
        Thread thread = new Thread(selectorTask);
        thread.start();
    }
}
