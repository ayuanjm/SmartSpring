package proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {
//    @Around("execution(* proxy.HelloImpl.*(..))")
    @Around("@annotation(org.smart4j.framework.annotation.Aspect)")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        //执行被切的方法
       // pjp.proceed();
        String className = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        System.out.println("className: " + className);
        System.out.println("methodName: " + methodName);
        System.out.println("args: " + pjp.getArgs()[0]);
        after();

    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }
}
