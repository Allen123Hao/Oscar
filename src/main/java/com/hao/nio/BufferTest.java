package com.hao.nio;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * <code>BufferTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-15
 * @version: 1.0
 */
public class BufferTest {

    public void func1() throws Exception{
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println("path:"+path);
        RandomAccessFile file = new RandomAccessFile(path+"/tmp.txt","rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println("limit:"+buffer.limit()+",position:"+buffer.position()+",capacity:"+buffer.capacity());
        channel.position(2);
        int bytesRead = channel.read(buffer);
        System.out.println("bytesRead:"+bytesRead);
        int r = channel.read(buffer);
        System.out.println("r:"+r);
        int d = channel.read(buffer);
        System.out.println("d:"+ d);
        System.out.println("position1:"+buffer.position());
        buffer.flip();
        System.out.println("limit2:"+buffer.limit()+",position2:"+buffer.position()+",capacity2:"+buffer.capacity());
        while (buffer.hasRemaining()){
            System.out.println((char)buffer.get());
        }
        System.out.println("limit3:"+buffer.limit()+",position3:"+buffer.position()+",capacity3:"+buffer.capacity());
        buffer.rewind();
        System.out.println("limit4:"+buffer.limit()+",position4:"+buffer.position()+",capacity4:"+buffer.capacity());
        while (buffer.hasRemaining()){
            System.out.println((char)buffer.get());
        }
        System.out.println("limit5:"+buffer.limit()+",position5:"+buffer.position()+",capacity5:"+buffer.capacity());
        buffer.clear();
//        System.out.println("limit6:"+buffer.limit());
//        System.out.println("position6:"+buffer.position());
//        System.out.println("capacity6:"+buffer.capacity());
//        while (buffer.hasRemaining()){
//            System.out.println((char)buffer.get());
//        }
        file.close();
    }

    public void func2() throws Exception{
        String s = "abcdefg";
        byte[] bytes = s.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(20);
        buffer.put(bytes,2,3);
        buffer.flip();
        while(buffer.hasRemaining()){
            System.out.println((char)buffer.get());
        }
        buffer.clear();
    }

    public void func3() throws Exception{
        String path = this.getClass().getClassLoader().getResource("").getPath();
        System.out.println("path:"+path);
        File file1 = new File(path+"/tmp.txt");
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.exists());
        if(file1.exists()){
            RandomAccessFile randomAccessFile = new RandomAccessFile(file1,"rw");
            String line = randomAccessFile.readLine();
            System.out.println(line);
        }
    }

    public void func4() throws Exception{
        String path = this.getClass().getClassLoader().getResource("").getPath();
        System.out.println("path:"+path);
        File file = new File(path+"/tmp.txt");
        FileChannel fileChannel = FileChannel.open(file.toPath(),StandardOpenOption.READ);
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(5);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(5);
        ByteBuffer[] buffers = {byteBuffer1,byteBuffer2};
        fileChannel.read(buffers);
        byteBuffer1.flip();
        byteBuffer2.flip();
        while(byteBuffer1.hasRemaining()){
            System.out.print((char)byteBuffer1.get());
        }
        System.out.println();
        while(byteBuffer2.hasRemaining()){
            System.out.print((char)byteBuffer2.get());
        }
    }

    public void func5() throws Exception{
        File file = new File("/Users/haoxueqiang/WorkSpace/oscar/src/main/resources/tmp.txt");
        String str = "Hello World!!!";
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        FileChannel fileChannel = FileChannel.open(file.toPath(),StandardOpenOption.WRITE,StandardOpenOption.READ);
        while(byteBuffer.hasRemaining()){
            fileChannel.write(byteBuffer);
        }
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(20);
        fileChannel.read(byteBuffer1);
        byteBuffer1.flip();
        while(byteBuffer1.hasRemaining()){
            System.out.println((char)byteBuffer1.get());
        }
        fileChannel.close();
    }

    public void func6(){
        int length = "hello".length();
        ByteBuffer buffer1 = ByteBuffer.allocate(length);
        buffer1.put("hello".getBytes());
        ByteBuffer buffer2 = ByteBuffer.allocate(length);
        buffer2.get("world".getBytes());
        System.out.println(buffer1.equals(buffer2));
        ByteBuffer buffer3 = ByteBuffer.wrap("hello".getBytes());
        System.out.println(buffer2.equals(buffer3));
        System.out.println("position1:"+buffer1.position()+",limit1:"+buffer1.limit()+",capacity1:"+buffer1.capacity());
        System.out.println("position2:"+buffer2.position()+",limit2:"+buffer2.limit()+",capacity2:"+buffer2.capacity());
        System.out.println("position3:"+buffer3.position()+",limit3:"+buffer3.limit()+",capacity3:"+buffer3.capacity());
    }

    public static void main(String[] args) throws Exception{
        BufferTest test = new BufferTest();
        test.func6();
    }
}
