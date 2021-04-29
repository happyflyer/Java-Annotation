package org.example.java_annotation.parse;

import java.lang.annotation.*;

/**
 * @author lifei
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description3 {
    String value();
}
