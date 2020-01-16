package com.hao.socket.heartbeat;

import com.hao.socket.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <code>ServiceTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/31
 * @version: 1.0
 */
public class ServiceTest {
    public static void main(String[] args) {
        try {
            ServerSocket ssl = new ServerSocket(8001);
            Runnable accumulatort = new Accumulatort(ssl);
            Thread thread = new Thread(accumulatort,"ThreadA");
            thread.start();
            System.out.println("服务启动完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Accumulatort implements Runnable{
    ServerSocket ss = null;
    public Accumulatort(ServerSocket s){
        this.ss = s;
    }
    @Override
    public void run() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while(true){
                Socket s = ss.accept();
                System.out.println(format.format(new Date()) + " " + "---------收到请求！");
                new Thread();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
