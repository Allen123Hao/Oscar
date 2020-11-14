package com.hao.test;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.junit.Test;
import scala.math.Ordering;

import java.util.ArrayList;
import java.util.List;

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
        int amount = 100000;
        for(int i=1;i<=10;i++){
            amount*=1.5;
            System.out.println(amount);
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
        System.out.println(Demo.class.getName());
        System.out.println(Demo.class.getSimpleName());
    }
}
