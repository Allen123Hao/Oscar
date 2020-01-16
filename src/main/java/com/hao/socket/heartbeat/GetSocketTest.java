package com.hao.socket.heartbeat;

import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <code>GetSocketTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/31
 * @version: 1.0
 */
public class GetSocketTest {

    public static void main(String[] args) {
        SocketKeep.initSocketKeep();
        while(true){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Socket socket1 = CommonSocket.getSocketByName("socket1");
                if(socket1 != null){
                    System.out.println(format.format(new Date())+" "+socket1.toString());
                    socket1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Socket socket2 = CommonSocket.getSocketByName("socket2");
                if(socket2 != null){
                    System.out.println(format.format(new Date())+" "+socket2.toString());
                    socket2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}
