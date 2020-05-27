package com.hao.io;

import java.io.PrintStream;

/**
 * <code>SystemOutDemo</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-04-21
 * @version: 1.0
 */
public class SystemOutDemo {

    public static void test1() throws Exception{
        PrintStream out = System.out;
        PrintStream ps = new PrintStream("./out.txt");
        PrintStream err = new PrintStream("./err.txt");
        System.setOut(ps);
        System.out.println("你是我的眼");
        System.out.println("我是中国人");
        System.setOut(out);
        System.out.println("这是一个崭新的时代");
        System.err.println("这是一个美丽的错误");
        System.setErr(err);
        System.err.println("这是一个美丽的谎言");

    }

    public static void main(String[] args) throws Exception{
        SystemOutDemo.test1();
    }
}
