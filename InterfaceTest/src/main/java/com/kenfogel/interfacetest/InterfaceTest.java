package com.kenfogel.interfacetest;

/**
 * A class that implements an interface
 *
 * @author Ken Fogel
 */
public class InterfaceTest implements ModernInterface {

    /**
     * The interface method that we must implement
     *
     * @return Just an arbirtary number for this example
     */
    @Override
    public int retrieveFlightTime() {
        return 42;
    }

    /**
     * Where it all begins
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var test = new InterfaceTest();
        // Call the implemented abstarct method
        System.out.println(test.retrieveFlightTime());
        // Call the default method from the interface class
        System.out.println(test.sayHello());
    }

}
