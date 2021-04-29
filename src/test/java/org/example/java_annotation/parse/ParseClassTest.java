package org.example.java_annotation.parse;

import org.junit.Test;

public class ParseClassTest {
    ParseClass parseClass2 = new ParseClass();

    @Test
    public void test1() {
        try {
            parseClass2.parseClassAnnotation1();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            parseClass2.parseClassAnnotation2();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            parseClass2.parseClassAnnotation3();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        try {
            parseClass2.parseClassAnnotation4();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() {
        try {
            parseClass2.parseMethodAnnotation1();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6() {
        try {
            parseClass2.parseMethodAnnotation2();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
