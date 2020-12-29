package org.example.java_annotation.parse2;

import java.lang.annotation.*;

/**
 * @author lifei
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description3 {
    String value();
}
