package com.hao.corejava;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * <code>ReferenceTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2021-02-24
 * @version: 1.0
 */
public class ReferenceTest {



    /**
     * 软引用测试
     */
    @Test
    public void test2(){
        String str1 = new String("abc");
        SoftReference<String> softReference = new SoftReference<>(new String("aaa"));
        System.out.println(softReference.get());
        str1 = null;
        System.gc();
        System.out.println(softReference.get());
    }

    /**
     * 弱引用测试
     */
    @Test
    public void test3(){
        String str1 = new String("abc");
        WeakReference<String> weakReference = new WeakReference<>(new String("aaa"));
        System.out.println(weakReference.get());
        str1 = null;
        System.gc();
        System.out.println(weakReference.get());
    }
}
