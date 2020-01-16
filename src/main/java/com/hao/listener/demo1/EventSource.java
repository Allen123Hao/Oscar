package com.hao.listener.demo1;

import java.util.Random;

/**
 * <code>EventSource</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/6/7
 * @version: 1.0
 */
public class EventSource {

    private Integer count0 = 0;

    private Integer count =0;

    private Listener listener;

    public Integer getCount0() {
        return count0;
    }

    public Integer getCount() {
        return count;
    }

    public void registerListener(Listener listener){
        this.listener = listener;
    }

    private void changeEvent(int i){
        if(count != i){
            count0 = count;
            count = i;
            Event event = new Event();
            event.setSource(this);
            listener.listenChange(event);
        }
    }

    public static void main(String[] args) {
        EventSource source = new EventSource();
        source.registerListener(new MyListener());
        source.changeEvent(100);
    }
}
