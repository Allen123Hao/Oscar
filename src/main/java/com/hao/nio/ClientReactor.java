package com.hao.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * <code>ClientReacor</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-25
 * @version: 1.0
 */
public class ClientReactor implements Runnable {
    final String host;
    final int port;
    final SocketChannel socketChannel;
    final Selector selector;
    private volatile boolean stop = false;

    public ClientReactor(String host, int port) throws IOException {
        this.socketChannel = SocketChannel.open();
        this.socketChannel.configureBlocking(false);
        Socket socket = this.socketChannel.socket();
        socket.setTcpNoDelay(true);
        this.selector = Selector.open();
        this.host = host;
        this.port = port;

    }

    @Override
    public void run() {

        try {
            // 如果通道呈阻塞模式，则立即发起连接；
            // 如果呈非阻塞模式，则不是立即发起连接，而是在随后的某个时间才发起连接。

            // 如果连接是立即建立的，说明通道是阻塞模式，当连接成功时，则此方法返回true，连接失败出现异常。
            // 如果此通道处于阻塞模式，则此方法的调用将会阻塞，直到建立连接或发生I/O错误。

            // 如果连接不是立即建立的，说明通道是非阻塞模式，则此方法返回false，
            // 并且以后必须通过调用finishConnect()方法来验证连接是否完成
            // socketChannel.isConnectionPending()判断此通道是否正在进行连接
            if (socketChannel.connect(new InetSocketAddress(host, port))) {
                socketChannel.register(selector, SelectionKey.OP_READ);
                doWrite(socketChannel);
            } else {
                socketChannel.register(selector, SelectionKey.OP_CONNECT);

            }
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

    private void handle(SelectionKey key) throws IOException {

        if (key.isValid()) {

            SocketChannel socketChannel = (SocketChannel) key.channel();

            if (key.isConnectable()) {
                if (socketChannel.finishConnect()) {
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    doWrite(socketChannel);
                }
            }

            if (key.isReadable()) {
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = socketChannel.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    System.out.println("recv server content: " + new String(bytes));
                } else if (readBytes < 0) {
                    key.cancel();
                    socketChannel.close();
                }
            }

        }
    }

    private void doWrite(SocketChannel socketChannel) {
        Scanner scanner = new Scanner(System.in);
        new Thread(() -> {
            while (scanner.hasNext()) {
                try {

                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                    writeBuffer.put(scanner.nextLine().getBytes());
                    writeBuffer.flip();
                    socketChannel.write(writeBuffer);
                } catch (Exception e) {

                }
            }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        new Thread(new ClientReactor("localhost",8081)).start();
    }
}


