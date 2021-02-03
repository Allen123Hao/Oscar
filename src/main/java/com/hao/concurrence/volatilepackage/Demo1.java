package com.hao.concurrence.volatilepackage;

/**
 * <code>Solution_70</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/5
 * @version: 1.0
 */
public class Demo1 {
    public static boolean asleep = false;

    public static void main(String[] args){
        for(int i=0;i<4;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    judge();
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                asleep = true;
                System.out.println("end");
            }
        }).start();
    }

    public static void judge(){
        while(!asleep){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CMS();
        }
    }
    public static void CMS(){
        System.out.println("@");
    }
}
