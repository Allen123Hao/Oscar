package com.hao.netty.demo2;


import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * <code>PlainOioServer</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/2/26
 * @version: 1.0
 */
public class PlainOioServer {
    public void server(int port) throws IOException{
        // 1.绑定服务器到指定的端口。
        final ServerSocket serverSocket = new ServerSocket(port);
        try {
            for(;;){
                // 2.接受一个连接。
                System.out.println("begin accept socket.");
                final Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket);

                //3.创建一个新的线程来处理连接。
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            out = clientSocket.getOutputStream();
                            out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                            //4.将消息发送到连接的客户端。
                            out.flush();
                            //5.一旦消息被写入和刷新时就 关闭连接。
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            try {
                                clientSocket.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }).start(); //6.启动线程。
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PlainOioServer server = new PlainOioServer();
        try {
            server.server(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
