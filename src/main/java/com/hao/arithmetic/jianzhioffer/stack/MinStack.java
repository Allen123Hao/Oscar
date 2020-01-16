package com.hao.arithmetic.jianzhioffer.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * <code>MinStack</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-05
 * @version: 1.0
 */
public class MinStack {

    private List<Integer> minList = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public Integer pop(){
        if(list.size() == 0){
            return null;
        }
        int value = list.get(list.size()-1);
        list.remove(list.size()-1);
        minList.remove(minList.size()-1);
        return value;
    }

    public void push(int val){
        list.add(val);
        if(minList.size() == 0){
            minList.add(val);
        }else{
            minList.add(Math.min(minList.get(minList.size()-1),val));
        }
    }

    public Integer getMin(){
        return minList.get(minList.size()-1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(9);
        minStack.push(7);
        minStack.push(4);
        minStack.push(3);
        minStack.push(8);
        minStack.push(5);
        while(!minStack.isEmpty()){
            System.out.println("min:"+minStack.getMin());
            System.out.println(minStack.pop());
        }
    }

}
