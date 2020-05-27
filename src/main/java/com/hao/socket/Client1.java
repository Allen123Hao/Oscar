package com.hao.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * <code>Client1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/1
 * @version: 1.0
 */
public class Client1 {
    public static void main(String[] args){
        String host = "127.0.0.1";
        int port = 8899;
        try {
            Socket client = new Socket(host,port,InetAddress.getByName("localhost"),8080);
            Writer writer = new OutputStreamWriter(client.getOutputStream());
            writer.write("Hello World!");
            writer.flush();
            writer.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
