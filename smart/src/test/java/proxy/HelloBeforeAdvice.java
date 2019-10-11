package proxy;

import org.smart4j.framework.annotation.Service;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
public class HelloBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before");
    }
}
