package com.hao.arithmetic.leetcode;

import java.util.*;

/**
 * <code>Solution_70</code>
 *
 * @description: 最大子序列
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/12/31
 * @version: 1.0
 */
public class Solution_3 {
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

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_3 solution3 = new Solution_3();
        int maxLength = solution3.lengthOfLongestSubstring("abcbefaedf");
        System.out.println(maxLength);
    }
}
