package com.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * 事件监听
 */
@Component
public class EventDemoListern implements ApplicationListener<EventDemo> {
    @Async
    @Override
    public void onApplicationEvent(EventDemo eventDemo) {
        try {
            System.out.println(Thread.currentThread().getName() + ":监听到事件处理开始:" + eventDemo.getMessage());
            //Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ":监听到事件处理结束:" + eventDemo.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @EventListener
//    void show(EventDemo demo) {
//        System.out.println("EventListener:" + demo);
//    }

}
