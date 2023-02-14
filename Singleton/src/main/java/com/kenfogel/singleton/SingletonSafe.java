package com.kenfogel.singleton;

/**
 * In this singleton we synchronize the creation of the object so that it cannot
 * be interrupted by other threads.
 *
 * @author Ken Fogel
 */
public class SingletonSafe {

    /*
     * There can only ever be one instance. As a field variable it will default
     * to a value of null.
     */
    private static SingletonSafe instance;

    /**
     * The private constructor
     */
    private SingletonSafe() {
    }

    /**
     * Either return a new instance if none exists or create one.
     *
     * @return
     */
    public static SingletonSafe getInstance() {
        synchronized (SingletonSafe.class) {
            if (instance == null) {
                instance = new SingletonSafe();
            }
        }
        return instance;
    }
}
