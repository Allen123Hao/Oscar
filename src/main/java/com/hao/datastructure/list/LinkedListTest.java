package com.hao.datastructure.list;

import java.util.LinkedList;

/**
 * <code>LinkedListTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/5/23
 * @version: 1.0
 */
public class LinkedListTest {
    public void func1(){
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("I");
        linkedList.add("am");
        linkedList.add("chinese");
        String last = linkedList.getLast();
        System.out.println(last);
    }
    public static void main(String[] args) {
        LinkedListTest test = new LinkedListTest();
        test.func1();
    }
}
