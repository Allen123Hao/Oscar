package com.hao.arithmetic.leetcode;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * <code>Solution_1</code>
 *
 * @description:
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
 *
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2021-01-25
 * @version: 1.0
 */
public class Solution_1 {

    public static int[] findElement1(int[] nums,int target){
        int[] result = new int[2];
        int len = nums.length;
        if(len < 2){
            return result;
        }
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len;j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
                if(nums[i] + nums[j] > target){
                    break;
                }
            }
        }
        return result;
    }

    //利用Map计算
    public static int[] findElement2(int[] nums,int target){
        int[] result = new int[2];
        int len = nums.length;
        if(len < 2){
            return result;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                result[0] = i;
                result[1] = map.get(temp);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] result = findElement2(nums,18);
        System.out.println(new Gson().toJson(result));
    }
}
