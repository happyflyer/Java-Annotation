package org.example.java_annotation.jdk;

/**
 * @author lifei
 */
public interface Person {
    /**
     * name
     *
     * @return String
     */
    String name();

    /**
     * age
     *
     * @return int
     */
    int age();

    /**
     * sing
     */
    @Deprecated
    void sing();
}
