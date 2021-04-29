package org.example.java_annotation.parse;

/**
 * @author lifei
 */
public class Child implements Human {
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
