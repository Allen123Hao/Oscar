package com.hao.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <code>Server2</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/1
 * @version: 1.0
 */
public class Server2 {
    public static void main(String[] args){
        int port = 8899;
        try {
            ServerSocket server = new ServerSocket(port);
            while(true){
                Socket socket = server.accept();
                new Thread(new Task(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable{
        private Socket socket;
        Task(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                handleSocket();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void handleSocket() throws Exception{
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String temp;
            int index;
            while((temp = reader.readLine()) != null){
                if((index = temp.indexOf("eof")) != -1){
                    sb.append(temp.substring(0,index));
                    break;
                }
                sb.append(temp);
            }
            System.out.println("from client " + socket.getInetAddress().getHostAddress() + ":" + sb.toString());
            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("already received the infomation of client "+socket.getInetAddress().getHostAddress()+"\n");
            writer.flush();
            reader.close();
            writer.close();
            socket.close();
        }
    }
}
