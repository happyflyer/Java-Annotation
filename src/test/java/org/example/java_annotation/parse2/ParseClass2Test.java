package org.example.java_annotation.parse2;

import org.junit.Test;

public class ParseClass2Test {
    @Test
    public void test() {
        ParseClass2 parseClass2 = new ParseClass2();
        try {
            parseClass2.parseClassAnnotation();
            System.out.println("==========");
            parseClass2.parseMethodAnnotation();
            System.out.println("==========");
            parseClass2.parseMethodAnnotation2();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
