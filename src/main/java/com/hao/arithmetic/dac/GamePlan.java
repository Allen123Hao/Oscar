package com.hao.arithmetic.dac;

import java.util.Scanner;

/**
 * <code>GamePlan</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/5/23
 * @version: 1.0
 */
public class GamePlan {
    private int max= 64;
    private int a[][] = new int[max+1][max+1];

    /**
     * 利用分治算法，递归解决问题
     * @param k
     * @param n
     */
    public void game_cal(int k,int n){
        if(n == 2){
            a[k][1] = k;
            a[k][2] = k+1;
            a[k+1][1] = k+1;
            a[k+1][2] = k;
        }else{
            game_cal(k,n/2);
            game_cal(k+n/2,n/2);
            //填充右上半部
            for(int i=k;i<k+n/2;i++){
                for(int j=n/2+1;j<=n;j++){
                    a[i][j] = a[i+n/2][j-n/2];
                }
            }
            //填充右下半部
            for(int i=k+n/2;i<k+n;i++){
                for(int j=n/2+1;j<=n;j++){
                    a[i][j] = a[i-n/2][j-n/2];
                }
            }
        }
    }



    public static void main(String[] args) {
        GamePlan gamePlan = new GamePlan();
        int num;
        System.out.println("enter the player numbers:");
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        int k = num;
        while(k%2 == 0){
            k = k/2;
        }
        if(k != 1) {
            System.out.println("比赛人数必须是2的幂次！");
            return;
        }

        gamePlan.game_cal(1, num);
        System.out.print(" n ");
        for(int i=1;i<num;++i){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i=1;i<=num;++i){
            System.out.print(" ");
            for(int j=1;j<=num;++j){
                System.out.print(gamePlan.a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
