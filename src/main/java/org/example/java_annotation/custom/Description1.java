package org.example.java_annotation.custom;

import java.lang.annotation.*;

/**
 * @author lifei
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description1 {
    String desc();

    String author();

    int age() default 18;
}
