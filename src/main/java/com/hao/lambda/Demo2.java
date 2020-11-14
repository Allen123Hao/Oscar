package com.hao.lambda;

import com.google.gson.Gson;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <code>Demo2</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-06-28
 * @version: 1.0
 */
public class Demo2 {

    @Test
    public void func1(){
        List<People> list = new ArrayList<>();
        list.add(new People(null,null,"Allen"));
        list.add(new People(null,null,"Jack"));
        list.add(new People(null,null,"Jams"));
        //改变每一个元素
        list.stream().forEach(p -> p.setAge(20));
        //不改变每个元素
        list.stream().peek(p -> p.setId(1));
        System.out.println(new Gson().toJson(list));
        //必须有返回值
        list.stream().peek(p -> p.setId(2)).collect(Collectors.toList());
        System.out.println(new Gson().toJson(list));
    }

    @Test
    public void func2(){
        List<People> list = new ArrayList<>();
        list.add(new People(null,20,"Allen"));
        list.add(new People(null,21,"Jack"));
        list.add(new People(null,null,"Jams"));
        list.add(new People(null,null,"Polo"));
        list.stream().filter(p -> p.getAge() == null).forEach(p-> p.setAge(30));
        list.stream().filter(p -> p.getAge() == null).peek(p-> p.setAge(30)).collect(Collectors.toList());
        System.out.println(new Gson().toJson(list));
    }

    @Test
    public void func3(){
        List<People> list = new ArrayList<>();
        list.stream().filter(p -> p.getId() == null).collect(Collectors.toList());
    }

    @Test
    public void func4(){
        List<People> list = new ArrayList<>();
        list.add(new People(null,20,"Allen"));
        list.add(new People(null,21,"Jack"));
        list.add(new People(null,null,"Jams"));
        list.add(new People(null,null,"Polo"));
        list = list.stream().filter(p -> p.getName().equals("aaa")).collect(Collectors.toList());
        System.out.println(new Gson().toJson(list));
    }

    @Test
    public void func5(){
        List<People> list = new ArrayList<>();
        list.add(new People(1,20,"Allen"));
        list.add(new People(1,25,"Jack"));
        list.add(new People(1,22,"Lucy"));
        list.add(new People(2,30,"Jams"));
        list.add(new People(3,25,"Polo"));
        Map<Integer,People> map1 = list.stream().collect(Collectors.toMap(People::getId, People-> People,
                (p1,p2) -> {p1.setAge(p1.getAge()+p2.getAge()); return p1;}));
        System.out.println(new Gson().toJson(map1));

        System.out.println(new Gson().toJson(list));

        Map<Integer,People> map2 = list.stream().collect(Collectors.toMap(People::getId, People-> People,
                (p1,p2) -> {
                    if(p1.getAge().intValue() > p2.getAge().intValue()){
                        return p1;
                    }else{
                        return p2;
                    }
        }));
        System.out.println(new Gson().toJson(map2));
    }

    @Test
    public void func6(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = df.format(LocalDate.now());
        System.out.println(date);
    }


}
