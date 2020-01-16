package com.hao.datastructure;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * <code>Demo1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/4/14
 * @version: 1.0
 */
public class Demo1 {
    public static byte[] charToByte(char c){
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }
    public static void test1(){
        String str = "中";
        char x = '中';
        byte[] bytes1 = null;
        byte[] bytes2 = null;
        try {
            bytes1 = str.getBytes("utf-8");
            bytes2 = charToByte(x);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("bytes1大小："+bytes1.length);
        System.out.println("bytes2大小："+bytes2.length);
    }
    public static void test2(){
        Integer a = 0xff00;
        System.out.println(a);
        System.out.println(Integer.bitCount(a));
        System.out.println(Integer.toBinaryString(a));
    }
    public static void test3(){
        char c = '中';
        byte[] bytes = charToByte(c);
        System.out.println(Arrays.toString(bytes));
        System.out.println("------");
        String str = String.valueOf(c);
        System.out.println(str);
        byte[] bytes1 = new byte[0];
        try {
            bytes1 = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(bytes1));
    }
    public static void main(String[] args) {
        Demo1.test3();
    }
}
