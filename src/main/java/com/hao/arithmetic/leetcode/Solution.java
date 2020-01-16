package com.hao.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <code>Demo1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/12/31
 * @version: 1.0
 */
public class Solution {
    /**
     * @resource https://leetcode.com/problems/longest-substring-without-repeating-characters/
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int index = 0;
        Queue<Character> maxQueue = new LinkedList<>();
        while((index+maxQueue.size()) <= length){
            Queue<Character> queue = new LinkedList<>();
            for(int i=index;i<length;i++){
                if(queue.contains(chars[i])){
                    if(queue.size() > maxQueue.size()){
                        maxQueue = queue;
                    }
                    index++;
                    break;
                }else{
                    queue.add(chars[i]);
                }
            }
        }
        return maxQueue.size();
    }


    public int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int index = 0;
        int max = 0;
        while((index+max) <= length){
            List<Character> list = new ArrayList<>();
            for(int i=index;i<length;i++){
                if(list.contains(chars[i])){
                    int len = list.size();
                    if(len > max){
                        max = len;
                    }
                    index++;
                    break;
                }else{
                    list.add(chars[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int maxLength = solution.lengthOfLongestSubstring("abcbefaedf");
        System.out.println(maxLength);
    }
}
