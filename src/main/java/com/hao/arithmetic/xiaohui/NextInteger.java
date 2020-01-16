package com.hao.arithmetic.xiaohui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <code>NextInteger</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-09
 * @version: 1.0
 */
public class NextInteger {

    /**
     * 全排序
     * @param input
     * @return
     */
    public static List<Integer> getAllInteger(Integer input){
        String in = String.valueOf(input);
        char[] chars = in.toCharArray();
        List<char[]> list = new ArrayList<>();
        allPermutation(chars,list,0);
        List<Integer> result = new ArrayList<>();
        for(char[] cs : list){
            StringBuilder sb = new StringBuilder();
            for(char c : cs){
                sb.append(c);
            }
            result.add(Integer.valueOf(sb.toString()));
        }
        return result;
    }

    public static void allPermutation(char[] chars,List<char[]> list,int start){
        if(start == chars.length-1){
            list.add(chars.clone());
        }else{
            for(int i=start;i<chars.length;i++){
                swap(chars,i,start);
                allPermutation(chars,list,start+1);
                swap(chars,start,i);
            }
        }
    }

    private static void swap(char[] chars,int i,int j){
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    /**
     * 排序
     * @param array
     * @return
     */
    public static Integer[] sort(Integer[] array){
        int length = array.length;
        for(int i=length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }


    public static void main(String[] args) {
        int a = 12354;
        List<Integer> list = getAllInteger(a);
        Integer[] array = sort(list.toArray(new Integer[list.size()]));
        for(Integer i : array){
            if(i.intValue() > a){
                System.out.println(i);
                break;
            }
        }
    }
}
