package com.hao.bigdata;

/**
 * <code>BitMap</code>
 *
 * @description: 实现BitMap 注：这个bitMap的index是从1开始的
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/5/30
 * @version: 1.0
 */
public class BitMap {
    private long length;

    private static int[] bitsMap;

    public BitMap(int length){
        this.length = length;
        bitsMap = new int[(length >> 5) + ((length & 31) > 0 ? 1 : 0)];
    }

    public int getBit(long index) {
        int intData = bitsMap[(int) ((index - 1) >> 5)];
        int offset = (int) ((index - 1) & 31);
        return intData >> offset & 0x01;
    }


    public void setBit(long index) {
        // 求出该index - 1所在bitMap的下标
        int belowIndex = (int) ((index - 1) >> 5);
        // 求出该值的偏移量(求余)
        int offset = (int) ((index - 1) & 31);
        int inData = bitsMap[belowIndex];
        bitsMap[belowIndex] = inData | (0x01 << offset);
    }

    public static void main(String[] args) {
        int i = 1 << 5 << 5;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        int len = (i >> 5) + ((i & 31) > 0 ? 1 : 0);
        System.out.println("len:"+len);
        BitMap bitMap = new BitMap(32);
        bitMap.setBit(32);
        System.out.println(bitMap.getBit(1));
        System.out.println(bitMap.getBit(32));
    }
}
