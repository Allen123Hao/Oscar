package com.hao.listener.demo1;

/**
 * <code>MyListener</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/6/7
 * @version: 1.0
 */
public class MyListener implements Listener{

    @Override
    public void listenChange(Event event) {
        EventSource source = event.getSource();
        System.out.println("事件源改变:"+source.getCount0()+"变为"+source.getCount());
    }
}
