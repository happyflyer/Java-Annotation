package org.example.java_annotation.parse2;

/**
 * @author lifei
 */
@Description3("interface Human")
public interface Human {
    /**
     * name
     *
     * @return String
     */
    @Description3("interface method name")
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
