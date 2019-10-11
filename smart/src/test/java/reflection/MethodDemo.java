package reflection;

import org.smart4j.framework.bean.Data;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Random;

public class MethodDemo {
    private String a;

    public static void main(String[] args) {
        String name = "reflection.Person";
        try {
              Class c = new Person().getClass();
              Class c2 = new Person("A",1).getClass();
              System.out.println(c==c2);
//            System.out.println(Math.random());
//            Class c = Class.forName(name);
//            Person.sycsynchronizedTest();
//            System.out.println(c);
//            Object obj = c.newInstance();
//            System.out.println(c.newInstance().getClass().getClassLoader());
//            //得到show方法，Integer类型参数
//            Method method = c.getDeclaredMethod("show",Integer.class);
//            //设置private方法可以调用
//            method.setAccessible(true);
//            //obj：类实例-对象，3：show方法实参
//            System.out.println(method.invoke(obj,3).getClass());
//            System.out.println(method.getParameterTypes()[0]);
//            //获取age属性
//            System.out.println("----------------");
//            Field field = c.getDeclaredField("name");
//            System.out.println(field);
//            System.out.println(field.getType());
//            //设置private成员可以修改访问
//            field.setAccessible(true);
//            field.set(obj,"yuan");
//            //成员名+成员值
//            System.out.println(field.getName()+":"+field.get(obj));
//            System.out.println(method.getDeclaringClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
