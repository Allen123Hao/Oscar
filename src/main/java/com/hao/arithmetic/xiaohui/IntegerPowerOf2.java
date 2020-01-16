package com.hao.arithmetic.xiaohui;

/**
 * <code>IntegerPowerOf2</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-06
 * @version: 1.0
 */
public class IntegerPowerOf2 {

    public static boolean isPowerOf2(int n){
        if(n == 0){
            return true;
        }
        if((n&1) != 0){
            return false;
        }
        if(n == 2){
            return true;
        }
        return isPowerOf2(n>>1);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(16));
    }
}
