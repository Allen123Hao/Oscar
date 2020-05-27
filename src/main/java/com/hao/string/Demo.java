package com.hao.string;

/**
 * <code>Demo</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/1/4
 * @version: 1.0
 */
public class Demo {


    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "a" + "b" + "c";
        String s4 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        System.out.println(s2 == s4);
        System.out.println("**********");
        System.out.println(s1.intern() == s2.intern());
        System.out.println(s1.intern() == s3.intern());
        System.out.println(s2.intern() == s3.intern());
        System.out.println(s2.intern() == s4.intern());
    }
}
