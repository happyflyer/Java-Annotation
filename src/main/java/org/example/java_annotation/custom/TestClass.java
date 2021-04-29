package org.example.java_annotation.custom;

/**
 * @author lifei
 */
@Description1(desc = "TestClass with Description1", author = "lifei")
public class TestClass {
    @Description1(desc = "test1 with Description1", author = "lifei")
    public void test1() {
        System.out.println("test1");
    }

    @Description1(desc = "test2 with Description1", author = "lifei")
    @Description2("test2 with Description2")
    public void test2() {
        System.out.println("test2");
    }
}
