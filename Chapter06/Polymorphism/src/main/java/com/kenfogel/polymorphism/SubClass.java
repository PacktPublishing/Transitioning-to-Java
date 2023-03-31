package com.kenfogel.polymorphism;

/**
 * A subclass for demonstrating polymorphism
 *
 * @author Ken Fogel
 */
public class SubClass extends SuperClass {

    /**
     * The superclass method we are overriding
     */
    @Override
    public void displayCount() {
        System.out.printf("SubClass count = %d%n", count);
    }

    public void tickleMe() {
        System.out.println("I'm tickled");
    }
}
