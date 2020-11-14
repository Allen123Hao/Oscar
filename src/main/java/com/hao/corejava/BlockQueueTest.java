package com.hao.corejava;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <code>BlockQueueTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-07-30
 * @version: 1.0
 */
public class BlockQueueTest {

    @Test
    public void func1(){
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
        queue.add("aaa");
        queue.add("bbb");
        queue.add("ccc");
        boolean result = queue.offer("ddd");
        System.out.println(result);
        List<String> list = new ArrayList<>();
        queue.drainTo(list);
        System.out.println(new Gson().toJson(list));
        System.out.println(queue.isEmpty());
    }
}
