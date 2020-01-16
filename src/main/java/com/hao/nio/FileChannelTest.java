package com.hao.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <code>FileChannelTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/15
 * @version: 1.0
 */
public class FileChannelTest {

    public void func1(){
        try {
            RandomAccessFile accessFile = new RandomAccessFile("E:\\test\\student.txt","rw");
            FileChannel inChannel = accessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buffer);
            while(bytesRead != -1){
                System.out.println("Read:" + bytesRead);
                buffer.flip();
                while(buffer.hasRemaining()){
                    System.out.print((char)buffer.get());
                }
                buffer.clear();
                bytesRead = inChannel.read(buffer);
            }
            accessFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileChannelTest test = new FileChannelTest();
        test.func1();
    }
}
