package com.hao.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * <code>TestPublish</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2019-11-05
 * @version: 1.0
 */
@Component
public class TestPublish implements ApplicationEventPublisherAware {

    private static ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        TestPublish.applicationEventPublisher = applicationEventPublisher;
    }

    public static void publishEvent(ApplicationEvent applicationEvent){
        applicationEventPublisher.publishEvent(applicationEvent);
    }
}
