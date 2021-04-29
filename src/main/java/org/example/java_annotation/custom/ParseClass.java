package org.example.java_annotation.custom;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author lifei
 */
public class ParseClass {
    public void parseClassAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.custom.TestClass");
        boolean isExist = clazz.isAnnotationPresent(Description1.class);
        if (isExist) {
            Description1 d = (Description1) clazz.getAnnotation(Description1.class);
            System.out.println(d.desc());
        }
    }

    public void parseMethodAnnotation1() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.custom.TestClass");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Description1.class)) {
                Description1 d = method.getAnnotation(Description1.class);
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
                if (a instanceof Description1) {
                    Description1 d = method.getAnnotation(Description1.class);
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
