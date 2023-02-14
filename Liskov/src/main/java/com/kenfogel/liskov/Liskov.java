package com.kenfogel.liskov;

/**
 * A subclass can be used in place of a superclass
 *
 * @author Ken Fogel
 */
public class Liskov {

    /**
     * While this method is expecting a SuperClass, it will accept a subclass
     *
     * @param sc
     */
    public void doDisplay(SuperClass sc) {
        sc.display("Ken");

    }

    /**
     * Where it all begins. We are passing an instance of the subclass to the
     * method expecting a superclass object
     *
     * @param args
     */
    public static void main(String[] args) {
        new Liskov().doDisplay(new SubClass());
    }

}
