package com.hao.corejava;

import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <code>User</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/8
 * @version: 1.0
 */
public class User implements Serializable{
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "username:"+userName+",password:"+password;
    }

    public void save(){
        User user = new User();
        user.setUserName("Hao Xueqiang");
        user.setPassword("123456");
        try {
            FileOutputStream fs = new FileOutputStream("user.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(user);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void read(){
        try {
            FileInputStream fs = new FileInputStream("user.txt");
            ObjectInputStream os = new ObjectInputStream(fs);
            User user = (User) os.readObject();
            System.out.println(user.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        String resource = User.class.getResource("").toString();
        System.out.println(resource);
//        User user = new User();
//        user.save();
//        user.read();
    }
}
