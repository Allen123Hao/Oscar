package com.hao.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * <code>TestEventHandler</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2019-11-06
 * @version: 1.0
 */
//@Component
public class TestEventHandler {

//    @Async
//    @EventListener
    public void onApplicationEvent(TestEvent event) {
        TestParam param = (TestParam) event.getSource();
        System.out.println(".......开始.......");
        System.out.println("发送电子邮箱:"+param.getEmail());
        System.out.println(".......结束.....");
    }

}
