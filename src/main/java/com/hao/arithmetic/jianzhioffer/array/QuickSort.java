package com.hao.arithmetic.jianzhioffer.array;

import java.util.Arrays;

/**
 * <code>QuickSort</code>
 *
 * @description: 参考：https://www.cnblogs.com/CBDoctor/p/4077574.html
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-11-30
 * @version: 1.0
 */
public class QuickSort {

    public static void sort(int[] arr,int left,int right){
        int i = left;
        int j = right;
        if(left > right){
            return;
        }
        int baseNum = arr[i];
        while(i < j){
            while(arr[j] >= baseNum && i < j){
                j--;
            }
            while(arr[i] <= baseNum && i < j){
                i++;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if(i == j){
            arr[left] = arr[i];
            arr[i] = baseNum;
        }
        sort(arr,left,i-1);
        sort(arr,j+1,right);
    }

    public static void main(String[] args) {
        int[] arr = {3,9,6,1,10,5,7,2};
        System.out.println(Arrays.toString(arr));
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
