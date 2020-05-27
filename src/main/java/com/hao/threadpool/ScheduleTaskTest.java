package com.hao.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <code>ScheduleTaskTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-14
 * @version: 1.0
 */
public class ScheduleTaskTest {

    private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public void func1(){
        service.schedule(new MyRunnable(),5000, TimeUnit.MILLISECONDS);
        service.shutdown();
    }

    public static void main(String[] args) {
        ScheduleTaskTest test = new ScheduleTaskTest();
        test.func1();
    }

    class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("执行任务");
        }
    }
}
