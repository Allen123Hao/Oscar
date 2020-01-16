package com.hao.arithmetic.xiaohui;

/**
 * <code>MaxCommonDivisor</code>
 *
 * @description: 计算最大公约数
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-18
 * @version: 1.0
 */
public class MaxCommonDivisor {

    public static int calMaxCommonDivisor1(int a,int b){
        int large = a > b ? a : b;
        int small = a < b ? a : b;

        if(large%small == 0){
            return small;
        }
        for(int i=small/2;i>1;i--){
            if(a%i==0 && b%i==0){
                return i;
            }
        }
        return 1;
    }

    public static int calMaxCommonDivisor2(int a,int b){
        int large = a > b ? a : b;
        int small = a < b ? a : b;
        if(large%small == 0){
            return small;
        }
        return calMaxCommonDivisor1(small,large%small);
    }

    public static int calMaxCommonDivisor3(int a,int b){
        int large = a > b ? a : b;
        int small = a < b ? a : b;
        if(large%small == 0){
            return small;
        }
        return calMaxCommonDivisor3(small,large-small);
    }

    public static void main(String[] args) {
        int result = calMaxCommonDivisor3(21,9);
        System.out.println(result);
    }
}
