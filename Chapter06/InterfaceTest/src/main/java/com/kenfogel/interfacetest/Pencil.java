package com.kenfogel.interfacetest;

/**
 * This interface class shows how you can write nethods with code in an
 * interface
 *
 * @author Ken Fogel
 */
public interface Pencil {

    /*
     * These abstract methods must be implemented
     */
    public void write1(); // Standard interface methods

    public void perform();

    /**
     * A default method is available to all classes that implement this
     * interface without the need to implement it in a class. It is a publice
     * method.
     */
    default void write2() {
        System.out.printf("default%n");
        write4();
    }

    /**
     * Like a static method in a class, you access this method using the
     * interface name
     */
    static void write3() {
        System.out.printf("static%n");
    }

    /**
     * A private method is used to supoort a default method. You cannot have
     * public methods unless they are abstract methods.
     */
    private void write4() {
        System.out.printf("private%n");
    }

}
