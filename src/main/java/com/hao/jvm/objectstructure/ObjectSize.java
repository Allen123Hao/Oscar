package com.hao.jvm.objectstructure;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.Test;

/**
 * <code>ObjectSize</code>
 *
 * @description: 对象由对象头(4个字节)、Class对象指针(4个字节)、对象实际数据(n个字节)、对齐字节(按8字节补齐)组成
 * 参考：https://blog.csdn.net/wuwenxiang91322/article/details/80216420/
 *      https://www.cnblogs.com/zhanjindong/p/3757767.html
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-12-08
 * @version: 1.0
 */
public class ObjectSize {

    @Test
    public void test1(){
        Integer i = 10;
        int j = 10;
        long size1 = ObjectSizeCalculator.getObjectSize(i);
        System.out.println(size1);
        long size2 = ObjectSizeCalculator.getObjectSize(j);
        System.out.println(size2);
    }

    @Test
    public void test2(){
        //16+3*16 =
//        Integer[] i = {1,2,3};
        Integer[] i = new Integer[3];
        long size = ObjectSizeCalculator.getObjectSize(i);
        System.out.println(size);
    }
}
