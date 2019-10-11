package proxy;

public class HelloProxy implements Hello{
    private Hello hello;
    @Override
    public void say(String name) {
        before();
        //hello.say(name);
        after();
    }
    public HelloProxy() {
        hello = new HelloImpl();
    }
    void before() {
        System.out.println("before");
    }
    void after(){
        System.out.println("after");
    }

    public Hello getHello() {
        return hello;
    }
}
