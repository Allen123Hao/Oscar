package com.hao.test;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;

/**
 * <code>DemoTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-07-03
 * @version: 1.0
 */
public class DemoTest {

    public static final int CELL_TYPE_NUMBER = 1;

    public static final int CELL_TYPE_STRING = 2;

    public static final int CELL_TYPE_DATE = 3;

    @Test
    public void func1(){
        int type = 1;
        switch (type){
            case DateUtils.RANGE_WEEK_SUNDAY:
                System.out.println(1);
                break;
            case DateUtils.RANGE_WEEK_MONDAY:
                System.out.println(2);
                break;
            case DateUtils.RANGE_WEEK_RELATIVE:
                System.out.println(3);
                break;
            default:
                break;
        }
    }

    @Test
    public void func2(){
        BigDecimal a = new BigDecimal("1.1");
        a.add(new BigDecimal("2"));
        System.out.println(a.toString());
    }

    @Test
    public void func3(){
        Map<String,String> properties = (Map)System.getProperties();
        Map<String,String> env = System.getenv();
        System.out.println(properties);
        System.out.println("***************");
        System.out.println(env);
    }
}
