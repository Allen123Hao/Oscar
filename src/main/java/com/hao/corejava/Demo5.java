package com.hao.corejava;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * <code>Demo5</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2021-02-24
 * @version: 1.0
 */
public class Demo5 {
    private byte[] bytes = new byte[1024*512];

//    static List<Demo5> list = new ArrayList<>();

    private static void test1(){
        Demo5 aa = new Demo5();

    }

    private static void test2(Demo5 aa){
//        Demo5 aa = new Demo5();
        SoftReference<Demo5> softReference = new SoftReference<>(aa);

    }

    @Override
    protected void finalize() throws Throwable {
//        list.add(this);
//        super.finalize();
    }


    public static void main(String[] args) {
        Demo5 aa = new Demo5();
        int i = 100;
        while(i>0){
            test1();
//            test2(aa);
            i--;
//            Demo4 aa = new Demo4();
        }
    }
}
