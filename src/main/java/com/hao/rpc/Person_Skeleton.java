package com.hao.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <code>Person_Skeleton</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/16
 * @version: 1.0
 */
public class Person_Skeleton extends Thread{
    private PersonServer personServer;
    public Person_Skeleton(PersonServer personServer){
        // get reference of object server
        this.personServer = personServer;
    }

    @Override
    public void run() {
        try {
            // new socket at port 1008
            ServerSocket serverSocket = new ServerSocket(1008);
            // accept stub's request
            Socket socket = serverSocket.accept();
            while(socket != null){
                // get stub's request
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                String method = (String) inputStream.readObject();
                if(method.equals("age")){
                    int age = personServer.getAge();
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeInt(age);
                    outputStream.flush();
                }
                if(method.equals("name")){
                    String name = personServer.getName();
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(name);
                    outputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        PersonServer person = new PersonServer(30,"Hao Xueqiang");
        Person_Skeleton skeleton = new Person_Skeleton(person);
        skeleton.start();
    }
}
