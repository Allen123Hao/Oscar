package com.hao.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <code>Person_Stub</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/16
 * @version: 1.0
 */
public class Person_Stub implements Person{
    private Socket socket;

    public Person_Stub() throws Throwable{
        // connect to skeleton
        socket = new Socket("172.25.126.82",1008);

    }

    @Override
    public int getAge() throws Throwable {
        // pass method name to skeleton
        ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject("age");
        outStream.flush();
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        return inputStream.readInt();
    }

    @Override
    public String getName() throws Throwable {
        // pass method name to skeleton
        ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject("name");
        outStream.flush();
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        return (String)inputStream.readObject();
    }
}
