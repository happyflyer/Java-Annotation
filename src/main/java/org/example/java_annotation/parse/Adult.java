package org.example.java_annotation.parse;

/**
 * @author lifei
 */
@Description3("class Adult with Description3")
public class Adult implements Human {
    @Override
    @Description3("class Adult method name with Description3")
    public String name() {
        return "adult";
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {
        System.out.println("adult sing");
    }
}
