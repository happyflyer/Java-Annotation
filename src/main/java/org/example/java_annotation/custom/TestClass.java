package org.example.java_annotation.custom;

/**
 * @author lifei
 */
@Description(desc = "TestClass description", author = "lifei")
public class TestClass {
    @Description(desc = "test1 description", author = "lifei")
    public void test1() {
        System.out.println("test1");
    }

    @Description2("test2 description")
    public void test2() {
        System.out.println("test2");
    }
}
