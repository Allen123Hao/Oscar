package com.hao.nio.example;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * <code>Server</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-19
 * @version: 1.0
 */
@Slf4j
public class Server {

    private static void execute(ServerSocketChannel serverSocketChannel){
        SocketChannel socketChannel = null;
        try {
            socketChannel = serverSocketChannel.accept();
            RequestObject requestObject = receiveData(socketChannel);
            log.info("服务端接收数据:{}",requestObject.toString());
            ResponseObject respObj = new ResponseObject(
                    "response for "+requestObject.getName(),
                    "response for "+requestObject.getValue());
            sendData(socketChannel,respObj);
            log.info("服务端发送数据:{}",respObj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static RequestObject receiveData(SocketChannel socketChannel){
        RequestObject requestObject = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        try {
            byte[] bytes;
            int size = 0;
            while((size = socketChannel.read(buffer)) >= 0){
                buffer.flip();
                bytes = new byte[size];
                buffer.get(bytes);
                baos.write(bytes);
                buffer.clear();
            }
            bytes = baos.toByteArray();
            requestObject = (RequestObject) SerializableUtil.toObject(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(),e);
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return requestObject;
    }

    private static void sendData(SocketChannel socketChannel,ResponseObject responseObj){
        try {
            byte[] bytes = SerializableUtil.toBytes(responseObj);
            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            socketChannel.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(),e);
        }

    }

    public static void main(String[] args) {
        Selector selector = null;
        ServerSocketChannel serverSocketChannel = null;

        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().setReuseAddress(true);
            serverSocketChannel.socket().bind(new InetSocketAddress(10000));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (selector.select() > 0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    execute((ServerSocketChannel) key.channel());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
