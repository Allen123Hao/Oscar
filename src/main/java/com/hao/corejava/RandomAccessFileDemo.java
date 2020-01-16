package com.hao.corejava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * <code>RandomAccessFileDemo</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/14
 * @version: 1.0
 */
public class RandomAccessFileDemo {

    public void fun1(){
        try {
            RandomAccessFile file = new RandomAccessFile("d:\\dest\\abc.txt","rw");
            file.writeInt(20);//占4个字节
            file.writeDouble(3.1415926);//占8个字节
            file.writeUTF("Hello World!");//这个长度写在当前文件指针的前两个字节处，可用readShort()读取
            file.writeBoolean(true);// 占1个字节
            file.writeShort(369);// 占2个字节
            file.writeLong(23456l);// 占8个字节
            file.writeUTF("您好啊");// 占11个字节，一个指针2个，一个汉字3个
            file.writeFloat(3.2f);// 占4个字节
            file.writeChar('c');// 占2个字节
            file.writeUTF("Over!");
            System.out.println("开始读取数据。。。");
            file.seek(0);
            System.out.println(file.readInt());
            System.out.println(file.readDouble());
            System.out.println(file.readUTF());
//            System.out.println(file.readBoolean());
//            System.out.println(file.readShort());
            file.skipBytes(3);
            System.out.println(file.readLong());
            file.skipBytes(11);
//            System.out.println(file.readUTF());
            System.out.println(file.readFloat());
            System.out.println(file.readChar());
            System.out.println(file.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fun2(){
        try {
            RandomAccessFile file = new RandomAccessFile("d:\\dest\\abc.txt","rw");
            file.writeUTF("你好");
            file.writeInt(30);
            System.out.println("开始读取数据。。。");
            System.out.println(file.getFilePointer());
//            System.out.println(file.readUTF());
            file.seek(8);
            System.out.println(file.readInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RandomAccessFileDemo demo = new RandomAccessFileDemo();
        demo.fun2();
    }
}
