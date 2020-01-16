package com.hao.concurrence.demo;

import java.util.concurrent.ExecutorService;

/**
 * <code>ExecutorTest1</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/6/5
 * @version: 1.0
 */
public class ExecutorTest1 {

    public static void main(String[] args) {
        Runnable runnable = new ExecutorTest.MyThread();
        ExecutorService service = ExecutorTest.getService();
        service.submit(runnable);
    }
}
