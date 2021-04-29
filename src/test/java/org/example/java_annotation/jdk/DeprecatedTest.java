package org.example.java_annotation.jdk;

import org.junit.Test;

public class DeprecatedTest {
    @Test
    @SuppressWarnings("deprecation")
    public void test() {
        Person person = new Child();
        person.name();
        person.age();
        person.sing();
    }
}
