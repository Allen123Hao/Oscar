package com.hao.nio;

import java.io.IOException;
import java.nio.channels.Selector;

/**
 * <code>SelectorWakeUpTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-07-28
 * @version: 1.0
 */
public class SelectorWakeUpTest {

    private Selector selector;

    public void func1(){
        Thread thread = new Thread(() -> {
            try {
                selector = Selector.open();
                int s = selector.select();
                selector.selectedKeys();
                System.out.println("s:"+s);
                System.out.println("sleep前:"+Thread.currentThread().isInterrupted());
                Thread.sleep(1000);
                System.out.println("继续");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("sleep后:"+Thread.currentThread().isInterrupted());
        });
        thread.start();
        thread.interrupt();
    }

    public void func2(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("selector wakeup");
        selector.wakeup();
    }

    public static void main(String[] args) {
        SelectorWakeUpTest wakeUpTest = new SelectorWakeUpTest();
        wakeUpTest.func1();
        wakeUpTest.func2();
    }
}
