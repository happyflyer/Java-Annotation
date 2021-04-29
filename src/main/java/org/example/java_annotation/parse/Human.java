package org.example.java_annotation.parse;

/**
 * @author lifei
 */
@Description3("interface Human with Description3")
public interface Human {
    /**
     * name
     *
     * @return String
     */
    @Description3("interface Human method name with Description3")
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
