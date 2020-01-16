package com.hao.arithmetic.xiaohui;

import java.util.Arrays;

/**
 * <code>MaximumAdjacentDifference</code>
 *
 * @description: 找到数组排序后两个数的最大距离
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-06
 * @version: 1.0
 */
public class MaximumAdjacentDifference {

    private static int findMaxDiff(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        int max = arr[0];
        int min = arr[0];
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        int d = max -min;
        if(d == 0){
            return 0;
        }
        int bucketNum = arr.length;
//        int bucketNum = d/arr.length +1;
        Bucket[] buckets = new Bucket[bucketNum];
        for(int j=0;j<bucketNum;j++){
            buckets[j] = new Bucket();
        }
        for(int k=0;k<arr.length;k++){
            int index = (arr[k]-min)*(bucketNum-1)/d;
            System.out.println("K:"+k+",arr[k]:"+arr[k]+",index:"+index);
//            int index = (arr[k]-min) / arr.length;
            if(buckets[index].min == null || buckets[index].min > arr[k]){
                buckets[index].min = arr[k];
            }
            if(buckets[index].max == null || buckets[index].max < arr[k]){
                buckets[index].max = arr[k];
            }
        }

        Integer leftMax = buckets[0].max;
        int distance = 0;
        for(int t=1;t<bucketNum;t++){
            if(buckets[t].min == null){
                continue;
            }
            if((buckets[t].min-leftMax)>distance){
                distance = buckets[t].min-leftMax;
            }
            leftMax = buckets[t].max;
        }

        return distance;
    }

    static class Bucket{
        public Integer min;
        public Integer max;
    }


    public static int findMaxDiff1(int[] arr){
        if(arr.length == 0 || arr.length == 1){
            return 0;
        }
        int max = arr[0];
        int min = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        int[] temp = new int[max+1];
        System.out.println("temp初始化前："+Arrays.toString(temp));
        for(int i=0;i<arr.length;i++){
            int index = arr[i];
            temp[index] = 1;
        }
        System.out.println("temp初始化后："+Arrays.toString(temp));
        int maxLength = 0;
        int curIndex = min;
        for(int j=min+1;j<temp.length;j++){
            if(temp[j] == 1 && j-curIndex > maxLength){
                maxLength = j-curIndex;
            }
            if(temp[j] == 1){
                curIndex = j;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] array = new int[] {2,6,3,4,5,10,9};
        int distance = findMaxDiff(array);
        System.out.println(distance);
    }
}
