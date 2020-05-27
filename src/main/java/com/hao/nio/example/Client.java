package com.hao.nio.example;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <code>Client</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-19
 * @version: 1.0
 */
@Slf4j
public class Client {



    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        for(int i=0;i<10;i++){
//            service.submit(new MyRunnable(i));
//        }
//        service.shutdown();
        MyRunnable runnable = new MyRunnable(0);
        runnable.run();
    }

    private static class MyRunnable implements Runnable{

        private int idx;

        private MyRunnable(int idx){
            this.idx = idx;
        }

        @Override
        public void run() {
            SocketChannel socketChannel = null;
            try {
                socketChannel = SocketChannel.open();
                SocketAddress socketAddress = new InetSocketAddress("localhost",10000);
                socketChannel.connect(socketAddress);
                RequestObject requestObject = new RequestObject(
                        "request_"+idx,"request_"+idx);
                log.info("客户端发送请求:{}",requestObject.toString());
                sendData(socketChannel,requestObject);
                ResponseObject responseObject = receiveData(socketChannel);
                log.info("客户端接收返回:{}",responseObject.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }

        }

        private void sendData(SocketChannel socketChannel,RequestObject requestObject){
            try {
                byte[] bytes = SerializableUtil.toBytes(requestObject);
                ByteBuffer buffer = ByteBuffer.wrap(bytes);
                socketChannel.write(buffer);
                socketChannel.socket().shutdownOutput();
                log.info("客户端发送结束");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        }

        private ResponseObject receiveData(SocketChannel socketChannel){
            ResponseObject responseObject = null;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int size = 0;
            byte[] bytes;
            try {
                while((size = socketChannel.read(buffer)) >= 0){
                    buffer.flip();
                    bytes = new byte[size];
                    buffer.get(bytes);
                    baos.write(bytes);
                    buffer.clear();
                }
                bytes = baos.toByteArray();
                responseObject = (ResponseObject) SerializableUtil.toObject(bytes);
                socketChannel.socket().shutdownInput();

            } catch (IOException e) {
                throw new RuntimeException(e.getMessage(),e);
            } finally {
                log.info("客户端接收结束");
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return responseObject;
        }
    }
}
