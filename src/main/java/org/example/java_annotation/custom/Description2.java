package org.example.java_annotation.custom;

import java.lang.annotation.*;

/**
 * @author lifei
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description2 {
    String value();
}
