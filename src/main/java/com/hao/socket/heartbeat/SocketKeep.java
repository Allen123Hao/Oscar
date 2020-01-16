package com.hao.socket.heartbeat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <code>SocketKeep</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/31
 * @version: 1.0
 */
public class SocketKeep {
    private static Log logger = LogFactory.getLog(SocketKeep.class);
    public static List<SocketEntity> socketEntityList = new ArrayList<SocketEntity>();

    /**
     * 共用连接检测间隔
     */
    public static int commonCheckTime = 2;

    /**
     * 连接对象保持，只保持需要系统保持的连接
     */
    public static Map<String,MySocket> socketMap = new LinkedHashMap<String,MySocket>();

    /**
     * 连接对象是否锁定 1：锁定，其他未锁定
     */
    public static Map<String,String> socketIsLock = new LinkedHashMap<String,String>();

    /**
     * 连接的数量，一定要和实际配置的数量匹配
     */
    public static int socketConnCount = 0;
    // 线程池
    public static ExecutorService executorService = null;

    /**
     *  初始化所有连接信息
     */
    public static void initSocketKeep(){
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(SocketKeep.class.getClassLoader().getResourceAsStream("system.property"));
            logger.warn("加载system.property文件成功！");
        } catch (IOException e) {
            logger.error("加载system.property文件失败！",e);
            properties = null;
            e.printStackTrace();
        }
        if(properties != null){
            try {
                commonCheckTime = Integer.parseInt(properties.getProperty("commonCheckTime"));
                socketConnCount = Integer.parseInt(properties.getProperty("socketConnCount"));
                executorService = Executors.newFixedThreadPool(socketConnCount+1);
            } catch (Exception e) {
                executorService = Executors.newFixedThreadPool(1);
                logger.error("解析共用信息时错误！", e);
                e.printStackTrace();
            }
            SocketEntity socketEntity = null;
            for(int i=1;i<socketConnCount;i++){
                String name = properties.getProperty("socket"+i);
                if(null != name){
                    socketEntity = new SocketEntity();
                    String ip = properties.getProperty("socket"+i+"_ip");
                    String port = properties.getProperty("socket"+i+"_port");
                    String isKeep = properties.getProperty("socket"+i+"_isKeep");

                    socketEntity.setName(name);
                    socketEntity.setIp(ip);
                    socketEntity.setPort(Integer.parseInt(port));
                    boolean keepConn = false;
                    if(null != isKeep && "1".equals(isKeep)){
                        keepConn = true;
                    }
                    socketEntity.setKeepConn(keepConn);
                    socketEntityList.add(socketEntity);
                }
            }
        }
        logger.warn("加载Socket连接配置信息结束！");
        logger.warn("开始初始化Socket连接！");
        MySocket socket = null;
        for(SocketEntity socketEntity : socketEntityList){
            if(socketEntity != null && socketEntity.isKeepConn()){
                try {
                    socket = new MySocket(socketEntity.getIp(),socketEntity.getPort());
                    socket.setSoTimeout(0);
                    socket.setKeepAlive(true);
                    socket.setName(socketEntity.getName());
                } catch (IOException e) {
                    logger.error("初始化某个连接时错误！错误的连接将放弃！资源名称：" + socketEntity.getName(), e);
                    socket = null;
                    e.printStackTrace();
                }
                if(null != socket){
                    socketMap.put(socketEntity.getName(),socket);
                }else{
                    socketMap.put(socketEntity.getName(),new MySocket());
                }
                socketIsLock.put(socketEntity.getName(),"0");
            }
        }

        // 开始执行检查
        executorService.execute(new CheckThread());
        logger.warn("初始化Socket连接结束！");
    }


}
