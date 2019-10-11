package proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

public class Demo {
    private static final Logger logger = LoggerFactory.getLogger(Demo.class);
    public static void main(String[] args){
//        ApplicationContext context = new ClassPathXmlApplicationContext("properties/applicationContext.xml");
//        Hello helloImpl = (Hello) context.getBean("helloImpl");
//        helloImpl.say("yuan");
//        System.out.println("----------------------------");
//        HelloImpl hello = (HelloImpl) helloImpl;
//        hello.goodMorning("jm");
//        logger.info("object:{},method:{}",hello,helloImpl);
        Hello hello = new DynamicProxy(new HelloImpl()).getProxy();
        hello.say("yuan");
        hello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),new Class[] {Hello.class},new DynamicProxy(new HelloImpl()));
        hello.say("a");
    }
}
