package com.hao.arithmetic.leetcode;

import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import org.junit.Test;

/**
 * <code>Solution_75</code>
 *
 * @description:https://leetcode.cn/problems/sort-colors/
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2022-11-10
 * @version: 1.0
 */
public class Solution_75 {

    public void sortColors(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            }else if(nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            }else {
                nums[num2++] = 2;
            }
        }
    }

    public void sortColors1(int nums[]){
        int n = nums.length;
        int p0 = 0;
        int p1 = n-1;
        for(int i=0;i<n;i++){
            while(i<p1 && nums[i] == 2){
                int temp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = temp;
                p1--;
            }
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }
    }

    @Test
    public void test(){
        int nums[] = {2,1,0,2,1,1,0};
        sortColors1(nums);
        System.out.println(JSONUtil.toJsonStr(nums));


    }
}
