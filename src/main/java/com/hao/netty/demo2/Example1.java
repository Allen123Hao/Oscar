package com.hao.netty.demo2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * <code>Example1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/4/12
 * @version: 1.0
 */
public class Example1 {
    List<Thread> list = new ArrayList<Thread>();
    public void func1(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String content = "郝学强";
        buffer.put(content.getBytes());
        System.out.println(buffer.remaining());
        buffer.flip();
        System.out.println(buffer.remaining());
        byte[] newArray = new byte[buffer.remaining()];
        buffer.get(newArray);
        String value = new String(newArray);
        System.out.println(value);
    }

    public void func2(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hahaha");
                System.out.println("name"+Thread.currentThread().getName());
                list.add(Thread.currentThread());
            }
        },"线程1");
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.get(0).getName());
        System.out.println(list.size());


    }

    public void func3(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8); //1

        ByteBuf sliced = buf.slice(0, 14);          //2
        System.out.println(sliced.toString(utf8));  //3

        buf.setByte(0, (byte) 'J');                 //4
        System.out.println(buf.getByte(0));
        System.out.println(sliced.getByte(0));
        assert buf.getByte(0) == sliced.getByte(0);
    }

    public void func4(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);     //1

        ByteBuf copy = buf.copy(0, 14);               //2
        System.out.println(copy.toString(utf8));      //3

        buf.setByte(0, (byte) 'J');                   //4
        System.out.println(buf.getByte(0));
        System.out.println(copy.getByte(0));
        assert buf.getByte(0) != copy.getByte(0);
    }

    public void func5(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);    //1
        System.out.println((char)buf.getByte(0));                    //2

        int readerIndex = buf.readerIndex();                        //3
        int writerIndex = buf.writerIndex();

        System.out.println("readerIndex:"+readerIndex);
        System.out.println("writerIndex:"+writerIndex);

        buf.setByte(0, (byte)'B');                            //4
        System.out.println("read:"+buf.readByte());

        System.out.println((char)buf.getByte(0));                    //5
        System.out.println("readerIndex:"+buf.readerIndex());
        System.out.println("writerIndex:"+buf.writerIndex());

        assert readerIndex == buf.readerIndex();                    //6
        assert writerIndex ==  buf.writerIndex();
    }

    public static void main(String[] args) {
        Example1 example1 = new Example1();
        example1.func5();
//
//        String s = "郝";
//        for(byte b : s.getBytes()){
//            System.out.print(b + " ");
//        }
//        System.out.println();
//        System.out.println(s.getBytes().length);
//        System.out.println(Integer.toBinaryString(72));
    }
}
