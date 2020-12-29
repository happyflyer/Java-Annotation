package org.example.java_annotation.parse2;

/**
 * @author lifei
 */
@Description3("class Person")
public class Person implements Human {
    @Override
    @Description3("class method name")
    public String name() {
        return "person";
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {
        System.out.println("person sing");
    }
}
