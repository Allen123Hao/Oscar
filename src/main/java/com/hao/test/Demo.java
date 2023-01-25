package com.hao.test;

import com.google.gson.Gson;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.junit.Test;
import scala.math.Ordering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <code>Demo</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-08-31
 * @version: 1.0
 */
public class Demo {

    @Test
    public void func1(){
        retry:
        for(int i=0;i<3;i++){
            for(int j=0;j<5;j++){
                if(j == 3){
                    continue retry;
                }
                System.out.println(j);
            }
        }
    }

    @Test
    public void func2(){
        Integer a = 200;
        Integer b = 200;
        System.out.println(a == b);
    }

    @Test
    public void func3(){
        int[] a = new int[3];
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.out.println(a);
    }

    @Test
    public void test4(){
        Audi audi = new Audi();
        audi.setId(1);
        audi.setName("奥迪");
        audi.setPrice(100.00f);
        Car car = audi;
        System.out.println(new Gson().toJson(car));
        Product product = audi;
        System.out.println(new Gson().toJson(product));
    }

    @Test
    public void test5(){
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()%1000);
        long i = 5000 - System.currentTimeMillis()%1000;
        System.out.println(i);

    }
}
