package reflection;

import proxy.Hello;
import proxy.HelloImpl;

import java.lang.reflect.*;

public class Demo {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflection.Person");
        Constructor constructor = cls.getConstructor(String.class, int.class);
        System.out.println(constructor.getName() + ": "
                + constructor.getParameterTypes()[0] + ":"
                + Modifier.toString(constructor.getModifiers()));
        Person person = (Person) constructor.newInstance("1", 1);
        System.out.println(person);
        Proxy.getProxyClass(Hello.class.getClassLoader(), new Class[]{Hello.class});
        Hello hello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), new Class[]{Hello.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object o = method.invoke(new HelloImpl(), args);
                return o;
            }
        });
        hello.say("a");
        Person person1 = new Person();
        System.out.println(person.name);
    }
}
