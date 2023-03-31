package com.kenfogel.interfacetest;

/**
 * An interface class that implements a default method
 *
 * @author Ken Fogel
 */
public interface ModernInterface {

    /*
     * Abstract method that must be implemented
     */
    public int retrieveFlightTime();

    /**
     * A default method is available to all classes that implement this
     * interface without the need to implement it in a class.It is a publice
     * method.
     * @return The arbitrary string "hello"
     */
    default String sayHello() {
        return "hello";
    }
}
