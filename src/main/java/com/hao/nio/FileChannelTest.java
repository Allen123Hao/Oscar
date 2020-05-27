package com.hao.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

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
            File file = new File("./temp.txt");
            if(!file.exists()){
                System.out.println("文件不存在");
            }
            RandomAccessFile accessFile = new RandomAccessFile("./temp.txt","rw");
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

    public void func2() throws Exception{
        String charset = Charset.defaultCharset().name();
        byte[] bytes = "我".getBytes(charset);
        byte[] bytes1 = new byte[bytes.length];
        for(int i=0;i<bytes.length;i++){
            System.out.println(bytes[i]);
            int temp = bytes[i] + 1;
            bytes1[i] = (byte) temp;
        }
        System.out.println("********");
        System.out.println(new String(bytes1,charset));
        byte[] bytes2 = new byte[]{-25,-119,-110};
        System.out.println(new String(bytes2,charset));
    }

    public static void main(String[] args) throws Exception{
        FileChannelTest test = new FileChannelTest();
        test.func1();

    }
}
