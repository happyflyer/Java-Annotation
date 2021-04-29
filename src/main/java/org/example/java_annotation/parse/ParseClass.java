package org.example.java_annotation.parse;

import java.lang.reflect.Method;

/**
 * @author lifei
 */
public class ParseClass {
    public void parseClassAnnotation1() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.parse.Adult");
        boolean isExist = clazz.isAnnotationPresent(Description3.class);
        if (isExist) {
            Description3 d = (Description3) clazz.getAnnotation(Description3.class);
            System.out.println(d.value());
        }
    }

    public void parseClassAnnotation2() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.parse.Child");
        boolean isExist = clazz.isAnnotationPresent(Description3.class);
        if (isExist) {
            Description3 d = (Description3) clazz.getAnnotation(Description3.class);
            System.out.println(d.value());
        }
    }

    public void parseClassAnnotation3() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.parse.Man");
        boolean isExist = clazz.isAnnotationPresent(Description3.class);
        if (isExist) {
            Description3 d = (Description3) clazz.getAnnotation(Description3.class);
            System.out.println(d.value());
        }
    }

    public void parseClassAnnotation4() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.parse.Woman");
        boolean isExist = clazz.isAnnotationPresent(Description3.class);
        if (isExist) {
            Description3 d = (Description3) clazz.getAnnotation(Description3.class);
            System.out.println(d.value());
        }
    }

    public void parseMethodAnnotation1() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.parse.Man");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Description3.class)) {
                Description3 d = method.getAnnotation(Description3.class);
                System.out.println(d.value());
            }
        }
    }

    public void parseMethodAnnotation2() throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.java_annotation.parse.Woman");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Description3.class)) {
                Description3 d = method.getAnnotation(Description3.class);
                System.out.println(d.value());
            }
        }
    }
}
