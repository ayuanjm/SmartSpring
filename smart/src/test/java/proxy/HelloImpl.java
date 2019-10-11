package proxy;

import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements Hello{
    @Override
    public void say(String name) {
        System.out.println("Hello：" + name);
        //throw new RuntimeException();
    }
    void goodMorning(String name){
        System.out.println("Good Morning!: " + name);
    }
}
