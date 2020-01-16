package com.hao.concurrence.forkjoin;

import org.apache.commons.lang.time.StopWatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * <code>Demo3</code>
 *
 * @description: 对比Demo2,通过ForkJoin实现
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/4/10
 * @version: 1.0
 */
public class Demo3 extends RecursiveTask<Integer>{

    private static final int THREAD_HOLD = 2;

    private int start;
    private int end;
    public Demo3(int start,int end){
        this.start = start;
        this.end = end;
    }


    @Override
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
            int middle = (start+end)/2;
            Demo3 leftTask = new Demo3(start,middle);
            Demo3 rightTask = new Demo3(middle+1,end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //获取子任务结果
            int lResult = leftTask.join();
            int rResult = rightTask.join();
            sum = lResult + rResult;

        }
        return sum;
    }

    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.start();
        ForkJoinPool pool = new ForkJoinPool();
        Demo3 task = new Demo3(1,6);
        Future<Integer> future = pool.submit(task);
        try {
            System.out.println("sum:"+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        watch.stop();
        System.out.println(watch.getTime());
    }
}
