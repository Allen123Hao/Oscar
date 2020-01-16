package com.hao.arithmetic.jianzhioffer.array;

import com.sun.tools.javac.util.List;
import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

/**
 * <code>MergeSort</code>
 *
 * @description: 归并，参考:https://www.cnblogs.com/chengxiao/p/6194356.html
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-11-29
 * @version: 1.0
 */
public class MergeSort {

    public static void sort(int[] arr){
        int[] temp = new int[arr.length];
        int left = 0;
        int right = arr.length-1;
        System.out.println(Arrays.toString(arr));
        sort(arr,left,right,temp);
    }

    public static void sort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        //如果参数不带临时数组，可以每次创建，将排好序的数组记录到新建的临时数组
        //int[] temp = new int[right-left+1];
        while(i<=mid && j<=right){
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        while(i <= mid) {
            temp[t++] = arr[i++];
        }
        while(j <= right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while(left <= right){
            arr[left++]=temp[t++];
        }
    }

    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
