package com.hao.arithmetic.xiaohui;

import java.util.Stack;

/**
 * <code>StackImplQueue</code>
 *
 * @description: 栈实现队列
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-09
 * @version: 1.0
 */
public class StackImplQueue {

    private Stack<Integer> stackA = new Stack<>();

    private Stack<Integer> stackB = new Stack<>();

    public boolean isEmpty(){
        if(stackA.isEmpty() && stackB.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public void push(Integer i){
        stackA.push(i);
    }

    public Integer pop(){
        if(!stackB.isEmpty()){
            return stackB.pop();
        }
        transfer();
        if(!stackB.isEmpty()){
            return stackB.pop();
        }else{
            return null;
        }
    }

    private void transfer(){
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        StackImplQueue stackImplQueue = new StackImplQueue();
        stackImplQueue.push(1);
        stackImplQueue.push(2);
        stackImplQueue.push(3);
        System.out.println(stackImplQueue.pop());
        stackImplQueue.push(4);
        stackImplQueue.push(5);
        while(!stackImplQueue.isEmpty()){
            System.out.println(stackImplQueue.pop());
        }
    }
}
