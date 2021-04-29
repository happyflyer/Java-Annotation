package org.example.java_annotation.custom;

import java.lang.annotation.*;

/**
 * @author lifei
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description2 {
    String value();
}
