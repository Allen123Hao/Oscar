package com.hao.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * <code>TestListener</code>
 *
 * @description: 事件监听器（Event Listnerer）
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2019-11-05
 * @version: 1.0
 */

@Component
public class TestListener implements ApplicationListener<TestEvent> {

//    @Async
    @Override
    public void onApplicationEvent(TestEvent event) {
        System.out.println("TestListener thread:"+Thread.currentThread().getName());
        TestParam param = (TestParam) event.getSource();
        System.out.println(".......开始.......");
        System.out.println("发送邮件:"+param.getEmail());
        System.out.println(".......结束.....");
    }
}
