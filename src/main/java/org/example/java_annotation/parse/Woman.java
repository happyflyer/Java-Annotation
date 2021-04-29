package org.example.java_annotation.parse;

/**
 * @author lifei
 */
public class Woman extends Adult{
    @Override
    @Description3("class Woman method name with Description3")
    public String name() {
        return "woman";
    }
}
