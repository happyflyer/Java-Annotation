package org.example.java_annotation.jdk;

/**
 * @author lifei
 */
public class Child implements Person {
    @Override
    public String name() {
        return "child";
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {
        System.out.println("child sing");
    }
}
