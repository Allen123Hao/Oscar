package com.hao.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <code>ServerReactor</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-25
 * @version: 1.0
 */
@Slf4j
public class ServerReactor implements Runnable {
    private final Selector selector;
    private final ServerSocketChannel serverSocketChannel;
    private volatile boolean stop = false;

    public ServerReactor(int port, int backlog) throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(port), backlog);
        serverSocket.setReuseAddress(true);
        serverSocketChannel.configureBlocking(false);
        // 将channel注册到多路复用器上，并监听ACCEPT事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        try {
            // 无限的接收客户端连接
            while (!stop && !Thread.interrupted()) {
                int num = selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    // 移除key，否则会导致事件重复消费
                    it.remove();
                    try {
                        handle(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void handle(SelectionKey key) throws Exception {
        if (key.isValid()) {
            // 如果是ACCEPT事件，代表是一个新的连接请求
            if (key.isAcceptable()) {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                // 相当于三次握手后，从全连接队列中获取可用的连接
                // 必须使用accept方法消费ACCEPT事件，否则将导致多路复用器死循环
                SocketChannel socketChannel = serverSocketChannel.accept();
                // 设置为非阻塞模式，当没有可用的连接时直接返回null，而不是阻塞。
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
            }

            if (key.isReadable()) {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = socketChannel.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String content = new String(bytes);
                    System.out.println("recv client content: " + content);
                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                    writeBuffer.put(("服务端已收到: " + content).getBytes());
                    writeBuffer.flip();
                    socketChannel.write(writeBuffer);

                } else if (readBytes < 0) {
                    key.cancel();
                    socketChannel.close();
                }
            }

        }
    }

    public static void main(String[] args) throws Exception{
        new Thread(new ServerReactor(8081,1)).start();
    }
}

