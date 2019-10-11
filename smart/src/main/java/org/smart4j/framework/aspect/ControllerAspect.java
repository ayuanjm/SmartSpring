package org.smart4j.framework.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.proxy.AspectProxy;

import java.lang.reflect.Method;

/**
 * 拦截Controller所有方法
 * @author yuan
 * @since 1.0.0
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;
    @Override
    public void before(Class<?> cls, Method method, Object[] params) {
        System.out.println("begin");
        System.out.println(String.format("class: %s", cls.getName()));
        System.out.println(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) {
        System.out.println(String.format("time: %dms",System.currentTimeMillis()-begin));
        System.out.println("after");
    }
}
