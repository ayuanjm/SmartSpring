package com.algorithm;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import reflection.Student;

@Component
public class FactoryBeanDemo implements FactoryBean<Student> {


    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("properties/applicationContext.xml");
        Object o = context.getBean("&factoryBeanDemo");//Demo01@59d4cd39
        Object o1 = context.getBean("factoryBeanDemo");//reflection.Student@389c4eb1

        // 1.Ioc容器在实例化bean的时候，Ioc会主动调用FactoryBean类型的的getObject方法来为我们生成对象吗？
        // 答: 一般情况下是不会的，一般情况碰到FactoryBean类型的是调用 getBean(&beanName),但是有一种情况例外，
        // 如果这个FactoryBean还实现了SmartInitializingSingleton接口的话，IOC就会帮我们主动调用getBean(beanName)来实例化；

    }
}
