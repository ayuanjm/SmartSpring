package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author yuan
 * 反射获取方法属性
 */
public class TestMethodAttribute {


    /**
     * 静态方法只能直接调用静态方法
     * 构造方法可以直接调用静态和非静态方法
     */
    private static void show() {
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("reflection.TestMethodAttribute");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("TestMethodAttribute()==>" + Modifier.toString(clazz.getConstructor().getModifiers()));
        System.out.println("show()==>" + Modifier.toString(clazz.getDeclaredMethod("show").getModifiers()));
    }
}
