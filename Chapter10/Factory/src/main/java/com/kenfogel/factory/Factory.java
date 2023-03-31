package com.kenfogel.factory;

/**
 * Here is where the classes are instantiated depending on the String passed to
 * getInstance. Commonly used when some preliminary work is required before the
 * objects are instantiated.
 *
 * @author Ken Fogel
 */
public class Factory {

    public static SharedInterface getInstance(String designator) {
        return switch (designator) {
            case "version01" ->
                new Version01();
            case "version02" ->
                new Version02();
            default ->
                null;
        };
    }

}
