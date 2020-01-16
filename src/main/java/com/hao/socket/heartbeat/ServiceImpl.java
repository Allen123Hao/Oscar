package com.hao.socket.heartbeat;

import java.io.IOException;
import java.net.Socket;

/**
 * <code>ServiceImpl</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/31
 * @version: 1.0
 */
public class ServiceImpl implements Runnable {
    Socket socket = null;
    public ServiceImpl(Socket s){
        this.socket = s;
    }
    @Override
    public void run() {
        boolean isKeep = true;
        try {
            while(isKeep){
                socket.sendUrgentData(0xFF);
                Thread.sleep(1*1000);
            }
        } catch (Exception e) {
            isKeep = false;
        }
    }
}
