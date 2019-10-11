package org.smart4j.framework.helper;

import org.smart4j.framework.util.ClassUtil;

/**
 * 加载相应的Help类
 *
 * @author yuan
 * @since 1.0.0
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classesList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classesList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
