package com.kenfogel.polymorphism;

/**
 * This class implements the Interface
 *
 * @author Ken Fogel
 */
public class Implementation implements Interface {

    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Here we are implementing the method that the interface class requires
     */
    @Override
    public void displayCount() {
        System.out.printf("Implementation count = %d%n", count);
    }
}
