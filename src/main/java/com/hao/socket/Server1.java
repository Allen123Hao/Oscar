package com.hao.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <code>Server1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/1
 * @version: 1.0
 */
public class Server1 {
    public static void main(String[] args){
        int port = 8899;
        try {
            //定义一个ServerSocket监听在端口8899上
            ServerSocket serverSocket = new ServerSocket(port);
            //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
            Socket socket = serverSocket.accept();
            //跟客户端建立好连接之后，我们就可以获取socket的InputStream，并从中读取客户端发过来的信息了。
            Reader reader = new InputStreamReader(socket.getInputStream());
            char[] chars = new char[64];
            int len;
            StringBuilder sb = new StringBuilder();
            while((len = reader.read(chars)) != -1){
                String temp = new String(chars,0,len);
                sb.append(temp);
            }
            System.out.println("from client:" + sb.toString());
            reader.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
