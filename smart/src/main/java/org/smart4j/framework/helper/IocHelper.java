package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.InjectYuan;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 * @author yuan
 * @since 1.0.0
 */
public class IocHelper {
    static {
        //获取所有的Bean类与Bean实例之间的映射关系（简称Bean Map）
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)){
            //遍历bean Map
            for (Map.Entry<Class<?>,Object> beanEntry : beanMap.entrySet()){
                //从 beanMap 中获取 bean类 bean实例
                Class<?> cls = beanEntry.getKey();
                Object obj = beanEntry.getValue();
                //获取bean类定义的所有成员变量（简称Bean Filed）
                Field[] fields = cls.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(fields)){
                    for (Field field:fields){
                        //判断当前Bean Field 是否带有InjectYuan注解
                        if (field.isAnnotationPresent(InjectYuan.class)){
                            //在Bean Map中获取Bean Field对应的实例
                            Class<?> beanFieldClass = field.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance!=null){
                                //通过反射初始化field的值
                                ReflectionUtil.setField(obj,field,beanFieldInstance);
                            }
                        }
                    }
                }

            }
        }
    }
}
