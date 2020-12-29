package org.example.java_annotation.parse;

import org.junit.Test;

public class ParseClassTest {
    @Test
    public void test() {
        ParseClass parseClass = new ParseClass();
        try {
            parseClass.parseClassAnnotation();
            System.out.println("==========");
            parseClass.parseMethodAnnotation();
            System.out.println("==========");
            parseClass.parseMethodAnnotation2();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
