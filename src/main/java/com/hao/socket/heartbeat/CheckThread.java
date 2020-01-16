package com.hao.socket.heartbeat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

/**
 * <code>CheckThread</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/31
 * @version: 1.0
 */
public class CheckThread implements Runnable {
    private static Log logger = LogFactory.getLog(CheckThread.class);
    @Override
    public void run() {
        while(true){
            MySocket socket = null;
            for(SocketEntity socketEntity : SocketKeep.socketEntityList){
                if(socketEntity != null && socketEntity.isKeepConn()){
                    String isLock = SocketKeep.socketIsLock.get(socketEntity.getName());
                    // 如果当前未被使用
                    if(!"1".equals(isLock)){
                        // 锁定引用
                        SocketKeep.socketIsLock.put(socketEntity.getName(),"1");
                        socket = SocketKeep.socketMap.get(socketEntity.getName());
                        try {
                            // 发送一个心跳包
                            socket.sendUrgentData(0xFF);
                            // 释放资源
                            SocketKeep.socketIsLock.put(socketEntity.getName(),"0");
                        } catch (IOException e) {
                            logger.error("检查连接时异常！启动重连！资源名称："+socketEntity.getName());
                            InitSocket initSocket = new InitSocket(socketEntity.getName());
                            new Thread(initSocket).start();
                        }
                    }
                }
            }
            try {
                logger.error("本次检测结束！");
                Thread.sleep(SocketKeep.commonCheckTime * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
