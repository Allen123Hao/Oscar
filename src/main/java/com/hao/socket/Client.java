package com.hao.socket;

import java.io.*;
import java.net.Socket;

/**
 * <code>Client</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/1
 * @version: 1.0
 */
public class Client {
    public static void main(String[] args){
        String host = "127.0.0.1";
        int port = 8899;
        try {
            Socket client = new Socket(host,port);
            Writer writer = new OutputStreamWriter(client.getOutputStream());
            int i=0;
            while(i<5){
                writer.write("Hello World!");
                writer.flush();
                i++;
            }
            writer.write("eof");
            writer.flush();
//            writer.close();
            Reader reader = new InputStreamReader(client.getInputStream());
            char[] chars = new char[64];
            int len;
            StringBuilder sb = new StringBuilder();
            while((len = reader.read(chars)) != -1){
                sb.append(new String(chars,0,len));
            }
            System.out.println("from server:" + sb.toString());
            writer.close();
            reader.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
