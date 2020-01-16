package com.hao.arithmetic.jianzhioffer.recursion;

/**
 * <code>CalHighestCommonFactor</code>
 *
 * @description: 求最大公约数
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-05
 * @version: 1.0
 */
public class CalHighestCommonFactor {

    public static int getCommonFactor(int a,int b){
        int max = a > b?a:b;
        int min = a > b?b:a;
        if(max % min == 0){
            System.out.println("check 0");
            return min;
        }
        if(max/min == 1){
            System.out.println("check 1");
            return 1;
        }
        int c = max % min;
        return getCommonFactor(min,c);
    }


    public static void main(String[] args) {
        int factor = getCommonFactor(5,3);
        System.out.println(factor);
    }

}
