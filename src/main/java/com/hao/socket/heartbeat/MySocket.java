package com.hao.socket.heartbeat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * <code>MySocket</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/31
 * @version: 1.0
 */
public class MySocket extends Socket {
    private String name;
    public MySocket(){
    }
    public MySocket(String ip,int port) throws UnknownHostException,IOException{
        super(ip,port);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 覆盖关闭的方法
     */
    @Override
    public synchronized void close() throws IOException{
        SocketKeep.socketIsLock.put(this.name,"0");
    }
}
