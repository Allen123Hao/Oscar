package com.hao.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * <code>TestEvent</code>
 *
 * @description: 事件状态对象（Event Object）
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2019-11-05
 * @version: 1.0
 */
public class TestEvent extends ApplicationEvent {

    private TestParam source;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public TestEvent(TestParam source) {
        super(source);
        this.source = source;
    }
}
