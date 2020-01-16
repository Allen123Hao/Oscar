package com.hao.socket;

import java.io.*;
import java.net.Socket;

/**
 * <code>Client2</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/1
 * @version: 1.0
 */
public class Client2 {
    public static void main(String[] args){
        String host = "127.0.0.1";
        int port = 8899;
        try {
            Socket client = new Socket(host,port);
//            client.setSoTimeout(10*1000);
            Writer writer = new OutputStreamWriter(client.getOutputStream());
            int i=0;
            while(i<5){
                writer.write("Hello World!\n");
                writer.flush();
                i++;
            }
            writer.write("eof\n");
            writer.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String temp;
            int index;
            StringBuilder sb = new StringBuilder();
            while((temp = reader.readLine()) != null){
                if((index = temp.indexOf("eof")) != -1){
                    sb.append(temp,0,index);
                }
                sb.append(temp);
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
