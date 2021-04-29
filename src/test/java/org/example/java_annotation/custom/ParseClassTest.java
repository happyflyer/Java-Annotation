package org.example.java_annotation.custom;

import org.junit.Test;

public class ParseClassTest {
    ParseClass parseClass = new ParseClass();

    @Test
    public void test1() {
        try {
            parseClass.parseClassAnnotation();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            parseClass.parseMethodAnnotation1();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            parseClass.parseMethodAnnotation2();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
