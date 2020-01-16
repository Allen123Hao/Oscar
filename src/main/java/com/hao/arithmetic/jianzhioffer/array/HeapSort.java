package com.hao.arithmetic.jianzhioffer.array;

import java.util.Arrays;

/**
 * <code>HeapSort</code>
 *
 * @description: 堆排序，参考：https://www.cnblogs.com/chengxiao/p/6129630.html
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-19
 * @version: 1.0
 */
public class HeapSort {

    /**
     * 构建数组0到n个元素找出最大的元素放到根节点，不能保证所有节点大于子节点
     * 类似选择排序，非真正的堆排序
     * @param arr
     * @param n
     */
    public static void sort(int[] arr,int n) throws Exception{
        int length = arr.length;
        if(n > length-1){
            throw new IndexOutOfBoundsException("数组越界");
        }
        for(int i=(n-1)/2;i>=0;i--){
            //父节点赋值
            int temp = arr[i];
            //左子节点
            int j = 2*i+1;
            //如果右子节点大于左子节点，则选出较大的
            if(j+1<=n && arr[j+1]>arr[j]){
                j++;
            }
            //判断父节点和较大子节点的大小
            if(arr[i] < arr[j]){
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    /**
     * 构造真正的大顶堆，保证所有节点大于子节点
     * @param arr
     * @param n 索引n，从0开始
     */
    public static void maxHeapSort(int[] arr,int n){
        int length = arr.length;
        if(n > length-1){
            throw new IndexOutOfBoundsException("数组越界");
        }
        //从第一个非叶子几点遍历，从右到左，从下到上遍历
        for(int i=(n-1)/2;i>=0;i--){
            int temp = arr[i];
            //遍历子节点，找到最小的位置赋值
            for(int k=2*i+1;k<=n;k=2*k+1){
                //寻找较大的子节点
                if(k+1<=n && arr[k] < arr[k+1]){
                    k++;
                }
                //如果子节点大于父节点，就把子节点赋值给父节点，并将此时k的位置赋给i，目的寻找i合适的位置
                if(arr[k] > temp){
                    arr[i] = arr[k];
                    i = k;
                }else{
                    break;
                }
            }
            //将需要遍历的非叶子节点的值放到合适的位置，然后遍历下一个节点
            arr[i] = temp;
        }
        System.out.println("前"+(n+1)+"元素最大堆："+Arrays.toString(arr));
    }

    /**
     * 前n个元素构建最小堆
     * @param arr
     * @param n 索引n，从0开始
     */
    public static void minHeapSort(int[] arr,int n){
        int length = arr.length;
        if(n > length-1){
            throw new IndexOutOfBoundsException("数组越界");
        }
        for(int i=(n-1)/2;i>=0;i--){
            int temp = arr[i];
            for(int k=2*i+1;k<=n;k=k*2+1){
                if(k+1<=n && arr[k+1] < arr[k]){
                    k++;
                }
                if(arr[k] < temp){
                    arr[i] = arr[k];
                    i = k;
                }else{
                    break;
                }
            }
            arr[i] = temp;
        }
    }

    public static void swap(int[] arr,int i,int j) throws Exception{
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 使用第一种方法，找出最大值放到根节点的方式
     * @param arr
     * @throws Exception
     */
    public static void func1(int[] arr) throws Exception{

        int len = arr.length;
        for(int i=len-1;i>0;i--){
            sort(arr,i);
            swap(arr,0,i);
        }

    }

    /**
     * 使用最大堆的方式
     * @param arr
     * @throws Exception
     */
    public static void func2(int[] arr) throws Exception{
        int len = arr.length;
        //先构建最大堆
        maxHeapSort(arr,len-1);
        for(int i=len-1;i>0;i--){
            swap(arr,0,i);
            maxHeapSort(arr,i-1);
        }
    }

    /**
     * 使用最小堆倒排序
     * @param arr
     * @throws Exception
     */
    public static void func3(int[] arr) throws Exception{
        minHeapSort(arr,arr.length-1);
        for(int i=arr.length-1;i>0;i--){
            swap(arr,0,i);
            minHeapSort(arr,i-1);
        }
    }

    public static void main(String[] args) throws Exception{
        int[] arr = {9,12,17,30,50,20,60,65,4,49};
//        func1(arr);
//        func2(arr);
        func3(arr);
        System.out.println(Arrays.toString(arr));
    }
}
