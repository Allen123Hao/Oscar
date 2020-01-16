package com.hao.netty.w3cschool;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * <code>PlainOioServer</code>
 *
 * @description: Blocking networking without Netty
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/4/12
 * @version: 1.0
 */
public class PlainOioServer {
    public void server(int port) throws IOException{
        final ServerSocket socket = new ServerSocket(port);
        try {
            for(;;){
                final Socket clientSocket = socket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            OutputStream out;
                            out = clientSocket.getOutputStream();
                            out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                            out.flush();
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
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        PlainOioServer server = new PlainOioServer();
        server.server(8081);
    }
}
