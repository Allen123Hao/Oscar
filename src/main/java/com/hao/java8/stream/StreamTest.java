package com.hao.java8.stream;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <code>StreamTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-03-06
 * @version: 1.0
 */
public class StreamTest {

    private static Gson gson = new Gson();

    public static void testFunction(){
        List<String> list = Stream.of("a","b","c")
                .map(x->x.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(gson.toJson(list));
    }

    public static void testPredicate(){
        List<String> list = Stream.of("a","b","c")
                .filter(x->x.equals("c"))
                .collect(Collectors.toList());
        System.out.println(gson.toJson(list));
    }

    public static void testConsumer(){
        List<String> list = Stream.of("a","b","c")
                .peek(x->x.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(gson.toJson(list));
    }

    public static void testConsumer1(){
        List<Person> list1 = Stream.of(new Person("Allen",30),new Person("Alice",25))
                .peek(person -> person.setAge(18))
                .collect(Collectors.toList());
        System.out.println(gson.toJson(list1));
    }


    public static void main(String[] args) {
        StreamTest.testConsumer();
    }
}
