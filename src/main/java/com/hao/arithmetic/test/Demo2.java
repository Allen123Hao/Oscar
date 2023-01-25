package com.hao.arithmetic.test;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONNull;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

/**
 * <code>Demo2</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2022-11-15
 * @version: 1.0
 */
public class Demo2 {

    public int binarySearch(int[] nums,int t){
        int length = nums.length;
        int left = 0;
        int right = length-1;
        while(left < right){
            int middle = left + (right-left)/2;
            if(nums[middle] < t){
                left = middle+1;
            }
            if(nums[middle] > t){
                right = middle;
            }
            if(nums[middle] == t){
                return middle;
            }

        }
        return -1;
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;

    }

    /**
     * 找到数组中的出现奇数次数的数
     * @param arr
     * @return
     */
    public int findNum(int arr[]){
        int num = 0;
        for(int val : arr){
            num = val ^ num;
        }
        return num;
    }

    @Test
    public void test1(){
        int[] nums = {1, 2, 4, 5, 6, 7, 9, 12, 15, 19, 23, 26, 29, 34, 39};
        int index = binarySearch(nums,26);
        System.out.println(index);
    }

    @Test
    public void test2(){
        int[] nums = {1,2};
        int[] result = sortedSquares(nums);
        System.out.println(JSONUtil.toJsonStr(result));
    }

    @Test
    public void test3(){
        int[] nums = {1,1,2,2,3,3,3,3,4,5,5,6,6,};
        int num = findNum(nums);
        System.out.println(num);
        System.out.println("====");
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(-46));
        System.out.println(6&-6);
    }
}
