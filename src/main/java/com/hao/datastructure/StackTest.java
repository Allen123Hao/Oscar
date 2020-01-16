package com.hao.datastructure;

import java.util.Stack;

/**
 * <code>StackTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/1
 * @version: 1.0
 */
public class StackTest {
    public static void main(String[] args){
        //11001001转为十进制
        String s = "11001001";
        char[] c = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<c.length;i++){
            stack.push(Integer.parseInt(String.valueOf(c[i])));
        }
        int result = 0;
        int j=0;
        while(!stack.empty()){
            int i = stack.pop();
            result += i*Math.pow(2,j++);
        }
        System.out.println(result);
    }
}
