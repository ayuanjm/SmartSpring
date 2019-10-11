package reflection;

import java.lang.reflect.Field;


public class GetFieldTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class clazz = Class.forName("reflection.Person");

        //1、获取字段
        //1.1 获取Field的数组,私有字段也能获取
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            System.out.print(field.getName() + ", ");
        }

        //1.2 获取指定名字的Field
        Field field = clazz.getDeclaredField("name");
        System.out.println("\n获取指定Field名=: " + field.getName());

        Person person = new Person("jaycee", 23);
        //2、获取指定对象的Field的值
        Object val = field.get(person);
        System.out.println("获取指定对象字段'name'的Field的值=：" + val);

        //3、设置指定对象的Field的值
        field.set(person, "admin");
        System.out.println("设置指定对象字段'name'的Field的值=: " + person.getName());

        //4、若该字段是私有的，需要调用setAccessible(true)方法
        Field field2 = clazz.getDeclaredField("age");
        //field2.setAccessible(true);
        System.out.println("获取指定私有字段名=: " + field2.getName());
    }
}