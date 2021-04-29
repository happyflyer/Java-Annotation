package org.example.java_annotation.parse;

/**
 * @author lifei
 */
@Description3("class Man with Description3")
public class Man extends Adult {
    @Override
    public String name() {
        return "man";
    }
}
