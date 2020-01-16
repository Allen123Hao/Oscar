package com.hao.socket.heartbeat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

/**
 * <code>InitSocket</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/31
 * @version: 1.0
 */
public class InitSocket implements Runnable {
    private static Log logger = LogFactory.getLog(InitSocket.class);
    /**
     * 是否有某个连接的配置信息，只有有配置信息才能建立连接
     */
    private static boolean isHave = false;
    private SocketEntity socketEntity = null;
    private String name;

    public SocketEntity getSocketEntity() {
        return socketEntity;
    }

    public void setSocketEntity(SocketEntity socketEntity) {
        this.socketEntity = socketEntity;
    }

    public InitSocket(String name){
        this.name = name;
        for(SocketEntity socketEntity : SocketKeep.socketEntityList){
            if(socketEntity != null && socketEntity.isKeepConn()){
                if(socketEntity.getName().equals(name)){
                    this.setSocketEntity(socketEntity);
                    isHave = true;
                }
            }
        }
    }

    @Override
    public void run() {
        boolean isError = true;
        MySocket socket = null;
        if(isHave){
            while(isError){
                try {
                    socket = new MySocket(this.getSocketEntity().getIp(),this.getSocketEntity().getPort());
                    socket.setSoTimeout(0);
                    socket.setKeepAlive(true);
                    socket.setName(this.name);
                    // 发送一个心跳包
                    socket.sendUrgentData(0xFF);
                } catch (IOException e) {
                    logger.error("建立资源连接时错误！资源：" + this.name, e);
                    socket = null;
                }
                if(socket != null){
                    SocketKeep.socketMap.put(this.getSocketEntity().getName(),socket);
                    SocketKeep.socketIsLock.put(this.getSocketEntity().getName(),"0");
                    logger.warn("建立资源连接成功！资源名称：" + this.name);
                    isError = false;
                }
                try {
                    Thread.sleep(2 * 1000);
                } catch (Exception e) {
                }
            }
        }else{
            logger.error("没有发现指定资源的配置信息！资源名称：" + this.name);
        }
        logger.warn("初始化资源执行结束！资源名称：" + this.name);
    }
}
