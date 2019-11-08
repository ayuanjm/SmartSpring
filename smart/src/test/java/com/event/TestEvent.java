package com.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/test.xml")
public class TestEvent {
//    @Autowired
//    private EventDemoPublish eventDemoPublish;

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("properties/test.xml");
        EventDemoPublish eventDemoPublish = (EventDemoPublish) context.getBean("eventDemoPublish");
        eventDemoPublish.publish("yuanjm");
    }

}
