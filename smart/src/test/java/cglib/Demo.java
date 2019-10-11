package cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Demo {
    public static void main(String[] args){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(ConcreteClassNoInterface.class);
        enhancer.setCallback(new ConcreteClassInterceptor());
        ConcreteClassNoInterface ccni=(ConcreteClassNoInterface)enhancer.create();
        ccni.getConcreteMethodA("yuan");
    }
}
