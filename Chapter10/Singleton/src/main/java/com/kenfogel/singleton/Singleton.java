package com.kenfogel.singleton;

/**
 * Here is a Singleton object. It has a private constructor so that it cannot be
 * instantiated with new. It has a static factory method, getInstance, that
 * either returns a new object or the existing singleton object
 *
 * @author Ken Fogel
 */
public class Singleton {

    /*
     * There can only ever be one instance. As a field variable it will default
     * to a value of null.
     */
    private static Singleton instance;

    /**
     * The private constructor
     */
    private Singleton() {
    }

    /**
     * Either return a new instance if none exists or create one
     *
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
