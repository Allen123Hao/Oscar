package com.hao.concurrence.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

/**
 * <code>TestMain</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/1/10
 * @version: 1.0
 */
public class TestMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(new MakeMoneyTask(1000000));
        do {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }while (!task.isDone());
        pool.shutdown();
        System.out.println(task.get());

    }
}
