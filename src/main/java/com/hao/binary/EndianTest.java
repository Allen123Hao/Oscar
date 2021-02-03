package com.hao.binary;

import org.jboss.netty.buffer.LittleEndianHeapChannelBuffer;
import org.junit.Test;

import java.nio.ByteOrder;

/**
 * <code>EndianTest</code>
 *
 * @description: 判断本地的端模式
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-12-10
 * @version: 1.0
 */
public class EndianTest {

    public void checkPCEndian(){
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            System.out.println("BIG_ENDIAN");
        } else {
            System.out.println("LITTLE_ENDIAN");
        }
    }

    @Test
    public void test1(){
        String s = "Hello";
        byte[] bytes = s.getBytes();
        for(byte b : bytes){
            System.out.print(b);
            System.out.print(" ");
        }
    }

    @Test
    public void test2(){
        byte[] bytes = {0,0,0,0,0,0,72,101,108,108,111};
        LittleEndianHeapChannelBuffer buffer = new LittleEndianHeapChannelBuffer(bytes);
        long length = buffer.getUnsignedInt(6);
        System.out.println(length);
    }

    public static void main(String[] args) {

    }
}
