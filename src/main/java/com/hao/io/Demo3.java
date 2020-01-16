package com.hao.io;

import java.io.*;

/**
 * <code>Demo3</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/2/27
 * @version: 1.0
 */
public class Demo3 {

    public static void func1() throws IOException{
        //        InputStreamReader reader = new InputStreamReader(System.in);
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("/Users/haoxueqiang/Work/binary.dat"));
        int t;
        System.out.println("input data:");
        while((t=System.in.read()) != 48){
            System.out.print(t + " ");
            dos.writeInt(t);
        }
        dos.flush();
        dos.close();
        System.out.println("=====");

        DataInputStream dis = new DataInputStream(new FileInputStream("/Users/haoxueqiang/Work/binary.dat"));
        for(int i=0;i<dis.available();i++){
            System.out.print(dis.readInt() + " ");
        }
        dis.close();
    }

    public static void func2() throws IOException{
        int count = -100;
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("/Users/haoxueqiang/Work/binary.dat"));
//        dos.write(count);
        dos.writeInt(count);
        DataInputStream dis = new DataInputStream(new FileInputStream("/Users/haoxueqiang/Work/binary.dat"));
        for(int i=0;i<dis.available();i++){
//            System.out.println(dis.read());
            System.out.println(dis.readInt());
        }
    }

    public static void main(String[] args) throws IOException {

        Demo3.func2();

    }
}
