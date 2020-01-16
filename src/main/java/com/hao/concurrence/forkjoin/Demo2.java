package com.hao.concurrence.forkjoin;

import org.apache.commons.lang.time.StopWatch;

import java.util.concurrent.RecursiveTask;

/**
 * <code>Demo2</code>
 *
 * @description: 求1+2+3+4的结果
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/4/10
 * @version: 1.0
 */
public class Demo2 {
    private static final int THREAD_HOLD = 2;

    private int start;
    private int end;

    public Demo2(int start,int end){
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) <= THREAD_HOLD;

        if(canCompute){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=start;i<=end;i++){
                sum += i;
            }
        }else{
            int middle = (end+start)/2;
            Demo2 leftTask = new Demo2(start,middle);
            Demo2 rightTask = new Demo2(middle+1,end);
            int leftSum = leftTask.compute();
            int rightSum = rightTask.compute();
            sum = leftSum+rightSum;
        }
        return sum;
    }

    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.start();
        Demo2 demo2 = new Demo2(1,6);
        int sum = demo2.compute();
        System.out.println("sum:"+sum);
        watch.stop();
        System.out.println(watch.getTime());
    }


}
