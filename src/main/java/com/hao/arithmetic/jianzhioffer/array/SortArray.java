package com.hao.arithmetic.jianzhioffer.array;

import com.sun.tools.javac.util.List;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * <code>SortArray</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-11-22
 * @version: 1.0
 */
//@Log4j
public class SortArray {

    private static Logger log = LoggerFactory.getLogger(SortArray.class);

    /**
     * 冒泡排序:两两比较将最大的放在最后面，再重复比较为排好的
     * @param arr
     * @return
     */
    public static Integer[] bubbleSort(Integer[] arr){
        if(arr == null){
            return null;
        }
        int length = arr.length;
        for(int i=0;i<length;i++){
            for(int j=0;j<length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序，从后面选择最小的，交换位置
     * @param arr
     * @return
     */
    public static Integer[] selectSort(Integer[] arr){
        log.info("选择排序……");
        if(arr == null){
            return null;
        }
        int length = arr.length;
        for(int i=0;i<=length-2;i++){
            int min = arr[i];
            int index = i;
            for(int j=i+1;j<=length-1;j++){
                if(arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            if(index != i){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        return arr;
    }

    /**
     * 前面作为已排好的序列，后面选出一个值来和序列倒着每个值比较，如果小于序列的当前值，
     * 当前值就后移一位，直到找到应该放置的位置
     * @param arr
     * @return
     */
    public static Integer[] insertSort(Integer[] arr){
        if(arr == null || arr.length == 1){
            return arr;
        }
        int length = arr.length;
        for(int i=1;i<length;i++){
            int t = arr[i];
            for(int j=i-1;j>=0;j--){
                if(t < arr[j]){
                    arr[j+1] = arr[j];
                    arr[j] = t;
                }else{
                    break;
                }
            }
        }
        return arr;
    }

    public static Integer[] insertSort1(Integer[] arr){
        if(arr == null || arr.length == 1){
            return arr;
        }
        int length = arr.length;
        for(int i=1;i<length;i++){
            int preIndex = i-1;
            int curValue = arr[i];
            while(preIndex >=0 && curValue < arr[preIndex]){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = curValue;
        }
        return arr;
    }

    /**
     * 希尔排序，插入排序的改进版，增加步长
     * @param arr
     * @return
     */
    public static Integer[] shellSort(Integer[] arr){
        if(arr == null || arr.length == 1){
            return arr;
        }
        int length = arr.length;
        int gap = length/2;
        while(gap >= 1){
            for(int i=gap;i<length;i++){
                int preIndex = i-gap;
                int curValue = arr[i];
                while(preIndex>=0 && curValue < arr[preIndex]){
                    arr[preIndex+gap] = arr[preIndex];
                    preIndex = preIndex -gap;
                }
                arr[preIndex+gap] = curValue;
                System.out.println("gap:"+gap+"    "+List.from(arr));
            }
            gap = gap/2;

        }
        return arr;
    }

    /**
     * 对两个有序数组合并排序
     * @param left
     * @param right
     * @return
     */
    public static int[] mergeSort(int[] left,int[] right){

        int[] result = new int[left.length+right.length];
        int curIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length){
            if(left[leftIndex] <= right[rightIndex]){
                result[curIndex] = left[leftIndex];
                leftIndex++;
                curIndex++;
            }else{
                result[curIndex] = right[rightIndex];
                rightIndex++;
                curIndex++;
            }
        }
        while(leftIndex < left.length){
            result[curIndex] = left[leftIndex];
            leftIndex++;
            curIndex++;
        }
        while(rightIndex < right.length){
            result[curIndex] = right[rightIndex];
            rightIndex++;
            curIndex++;
        }
        return result;
    }




    public static void main(String[] args) {
        Integer[] array = {5,9,2,1,7,3,10,9,4};
        System.out.println("排序前："+List.from(array));
//        bubbleSort(array);
//        selectSort(array);
//        insertSort1(array);
//        shellSort(array);
        System.out.println("排序后："+List.from(array));

        int[] left = {1,3,9,11};
        int[] right = {2,5,9,10};

        int[] result = mergeSort(left,right);
        System.out.println(List.from(ArrayUtils.toObject(result)));
    }
}
