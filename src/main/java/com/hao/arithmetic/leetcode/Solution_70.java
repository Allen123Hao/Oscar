package com.hao.arithmetic.leetcode;

/**
 * <code>Solution_70</code>
 *
 * @description:
 * 走台阶算法（本质上是斐波那契数列）在面试中常会遇到，描述就如题目那样：总共100级台阶（任意级都行），
 * 小明每次可选择走1步、2步或者3步，问走完这100级台阶总共有多少种走法？
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-12-01
 * @version: 1.0
 */
public class Solution_70 {
    /**
     * 这个问题本质上是斐波那契数列，假设只有一个台阶，那么只有一种跳法，那就是一次跳一级，f(1)=1；
     * 如果有两个台阶，那么有两种跳法，第一种跳法是一次跳一级，第二种跳法是一次跳两级,f(2)=2。如果
     * 有大于2级的n级台阶，那么假如第一次跳一级台阶，剩下还有n-1级台阶，有f(n-1)种跳法，假如第一次
     * 跳2级台阶，剩下n-2级台阶，有f(n-2)种跳法。
     * 这就表示f(n)=f(n-1)+f(n-2)。将上面的斐波那契数列代码稍微改一下就是本题的答案。我们来看一下代码的实现。
     */
    public int compute(int s){
        if(s == 0){
            return 0;
        }
        if(s == 1){
            return 1;
        }
        if(s == 2){
            return 2;
        }
        return compute(s-1) + compute(s-2);
    }

    /**
     * 打印出各种情况
     */

    //总楼梯数
    final int s = 5;

    //每步的索引
    int len;

    int step[] = new int[s];

    //总共多少种
    int sum;

    public void compute1(int s){
        if(s < 0){
            return;
        }
        //表示已经走完了
        if(s == 0){
            sum++;
            printSum();
            return;
        }
        //每次到下一步选择时都可以走1-2步
        for(int i=1;i<=2;i++){
            step[len] = i;
            len++;
            //进行下一步的迭代，迭代完之后将每步加上的一步去掉，换成其它的步数(如从1换成2)
            compute1(s-i);
            len--;
        }
    }

    private void printSum(){
        for(int i=0;i<len;i++){
            System.out.print(step[i]+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution_70 demo1 = new Solution_70();
//        int result = demo1.compute(4);
//        System.out.println(result);
        demo1.compute1(4);
        System.out.println("种数："+demo1.sum);
    }
}
