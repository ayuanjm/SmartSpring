package com.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 事件发布
 */
@Component
public class EventDemoPublish {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(String message) {
        EventDemo eventDemo = new EventDemo(this, message);
        System.out.println(Thread.currentThread().getName()+":publishEvent事件开始");
        applicationEventPublisher.publishEvent(eventDemo);
        System.out.println(Thread.currentThread().getName()+":publishEvent事件结束");
    }
}
