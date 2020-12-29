package org.example.java_annotation.parse;

import org.example.java_annotation.custom.Description;
import org.example.java_annotation.custom.Description2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author lifei
 */
public class ParseClass {
    public void parseClassAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.custom.TestClass");
        boolean isExist = clazz.isAnnotationPresent(Description.class);
        if (isExist) {
            Description d = (Description) clazz.getAnnotation(Description.class);
            System.out.println(d.desc());
        }
    }

    public void parseMethodAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.custom.TestClass");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Description.class)) {
                Description d = method.getAnnotation(Description.class);
                System.out.println(d.desc());
            }
        }
    }

    public void parseMethodAnnotation2() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.custom.TestClass");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation a : annotations) {
                if (a instanceof Description) {
                    Description d = method.getAnnotation(Description.class);
                    System.out.println(d.desc());
                }
                if (a instanceof Description2) {
                    Description2 d = method.getAnnotation(Description2.class);
                    System.out.println(d.value());
                }
            }
        }
    }
}
