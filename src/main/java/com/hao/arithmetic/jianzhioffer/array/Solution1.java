package com.hao.arithmetic.jianzhioffer.array;

/**
 * <code>Solution1</code>
 *
 * @description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-11-18
 * @version: 1.0
 */
public class Solution1 {

    /**
     * 正常遍历，时间复杂度是n
     * 运行时间：279ms，占用内存：17560k
     * @param target
     * @param array
     * @return
     */
    public boolean find_1(int target, int [][] array){
        for(int i=0;i<array.length;i++){
            int[] k = array[i];
            for(int j=0;j<k.length;j++){
                int t = array[i][j];
                if(target == t){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从左下角遍历，如果小于目标值右移，如果大于目标值左移
     * 运行时间：188ms  占用内存：17340k
     * @param target
     * @param array
     * @return
     */
    public boolean find_2(int target, int [][] array){
        int line = array.length;
        if(line == 0){
            return false;
        }
        int column = array[0].length;
        if(column == 0){
            return false;
        }
        int i = line-1,j=0;
        int cur = array[i][j];
        while(cur != target){
            if(cur < target && j < column-1){
                j++;
            }else if(cur > target && i > 0){
                i--;
            }else{
                break;
            }
            cur = array[i][j];
        }
        if(cur == target){
            return true;
        }else{
            return false;
        }
    }

    public boolean find_3(int target, int [][] array) {
        int rows = array.length;
        if(rows == 0){
            return false;
        }
        int cols = array[0].length;
        if(cols == 0){
            return false;
        }
        // 左下
        int row = rows-1;
        int col = 0;
        while(row>=0 && col<cols){
            if(array[row][col] < target){
                col++;
            }else if(array[row][col] > target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Solution1 solution = new Solution1();

        int[][] arr = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean result = solution.find_3(100,arr);
//        int[][] arr = new int[0][0];
//        boolean result = solution.find_2(16,arr);
        System.out.println(result);
    }
}
