package com.hao.jvm.load;

/**
 * <code>ClassInfo</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-12
 * @version: 1.0
 */
public class ClassInfo {

    private final int type = initType();

    private String name;

    static{
        System.out.println("静态块");
    }

    public ClassInfo(){
        System.out.println("构造方法");
    }

    public static int initType(){
        System.out.println("静态方法");
        return 1;
    }
}
