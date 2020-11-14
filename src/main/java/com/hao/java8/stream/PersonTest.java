package com.hao.java8.stream;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <code>PersonTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-03-19
 * @version: 1.0
 */
public class PersonTest {
    public void test(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("Allen",30));
        list.add(new Person("Chalse",23));
        list.add(new Person("James",23));
        list.add(new Person("Jack",40));
        list.add(new Person("Lucy",20));
        System.out.println(new Gson().toJson(list));
        list = list.stream().filter(p ->
                p.getName().indexOf("e") >=0
                        || p.getAge().intValue() == 20)
                .collect(Collectors.toList());
        System.out.println(new Gson().toJson(list));
        Map<String,Integer> map = list.stream().collect(Collectors.toMap(p->p.getName(), p->p.getAge()));
    }

    public static void main(String[] args) {
        PersonTest test = new PersonTest();
        test.test();
    }
}
