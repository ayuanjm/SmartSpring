package org.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 *  切面注解
 * @author yuan
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
