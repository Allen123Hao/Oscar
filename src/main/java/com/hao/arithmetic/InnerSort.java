package com.hao.arithmetic;

import java.util.Collections;

/**
 * <code>InnerSort</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/8
 * @version: 1.0
 */
public class InnerSort {
    /**
     * 冒泡排序，从小到大，平均时间复杂度O(n^2)
     * @param arr
     */
    public static void BubbleSort(int[] arr){
        int temp;
        for(int i=0;i<arr.length;i++){
            for(int j=arr.length-1;j>i;j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    /**
     * 优化冒泡算法
     * @param arr
     */
    public static void BubbleSort1(int[] arr){
        int temp;
        boolean flag = false;
        for(int i=0;i<arr.length;i++){
            for(int j=arr.length-1;j>i;j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    /**
     * 选择排序，平均时间复杂度O(n^2)
     * @param arr
     */
    public static void selectSort(int[] arr){
        int temp;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void selectSort1(int[] arr){
        int temp;
        for(int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /**
     * 插入排序，平均时间复杂度O(n^2)
     * @param arr
     */
    public static void insertSort(int[] arr){
        int temp;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void shellSort(int[] arr,int length){
        int temp = 0;
        int incre = length;
        while(true){
            incre = incre/2;
            for(int k=0;k<incre;k++){
                for(int i=k+incre;i<length;i+=incre){
                    for(int j=i;j>k;j-=incre){
                        if(arr[j] < arr[j-incre]){
                            temp = arr[j];
                            arr[j] = arr[j-incre];
                            arr[j-incre] = temp;
                        }else{
                            break;
                        }
                    }
                }
            }
            if(incre == 1){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {42,20,17,13,28,14,23,15};
//        InnerSort.BubbleSort1(arr);
//        InnerSort.selectSort(arr);
//        InnerSort.selectSort1(arr);
//        InnerSort.insertSort(arr);
        InnerSort.shellSort(arr,arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
