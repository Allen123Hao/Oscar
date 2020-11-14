package com.hao.bytecode;

/**
 * <code>ByteCodeDemo</code>
 *
 * @description: 字节码增强技术，通过javap -v ByteCodeDemo.class查看字节码
 * 相关文档：https://tech.meituan.com/2019/09/05/java-bytecode-enhancement.html
 *         https://blog.csdn.net/luanlouis/article/details/39960815
 *         https://blog.csdn.net/luanlouis/article/details/40301985
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-09-30
 * @version: 1.0
 */
public class ByteCodeDemo {

    private int a = 1;

    private int add1(){
        int b = 5;
        int c = a + b;
        System.out.println(c);
        return c;
    }

    private int add2(){
        int b = 6;
        int c = a + b;
        System.out.println(c);
        return c;
    }



    public void test(){
        add2();
    }
}

