package com.hao.lambda;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;

/**
 * <code>Demo3</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-09-18
 * @version: 1.0
 */
public class Demo3 {

    @Test
    public void func1(){
        String key = "a";
        Map<String, List<String>> target = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        target.put(key, list);
        List<String> values = target.computeIfAbsent(key,k -> {return new ArrayList<>();});
        values.add("3");
        values.add("4");
        values.add("1");
        System.out.println(new Gson().toJson(target));
    }

    @Test
    public void func2(){
        List<String> list = Arrays.asList("1","2");
        list.add("3");
        System.out.println(list);
    }
}
