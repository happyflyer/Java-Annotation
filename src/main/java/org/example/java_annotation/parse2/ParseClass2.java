package org.example.java_annotation.parse2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author lifei
 */
public class ParseClass2 {
    public void parseClassAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.parse2.Child");
        boolean isExist = clazz.isAnnotationPresent(Description3.class);
        if (isExist) {
            Description3 d = (Description3) clazz.getAnnotation(Description3.class);
            System.out.println(d.value());
        }
    }

    public void parseMethodAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.parse2.Child");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Description3.class)) {
                Description3 d = method.getAnnotation(Description3.class);
                System.out.println(d.value());
            }
        }
    }

    public void parseMethodAnnotation2() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.parse2.Child");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation a : annotations) {
                if (a instanceof Description3) {
                    Description3 d = method.getAnnotation(Description3.class);
                    System.out.println(d.value());
                }
            }
        }
    }
}
