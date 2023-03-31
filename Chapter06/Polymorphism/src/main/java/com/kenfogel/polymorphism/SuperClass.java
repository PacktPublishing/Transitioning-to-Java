package com.kenfogel.polymorphism;

/**
 * The superclass for the polymorphism example
 *
 * @author Ken Fogel
 */
public class SuperClass {

    /*
     * We are using protected access for the variable count so that it is
     * accesible in all subclasses
     */
    protected int count;

    public void setCount(int count) {
        this.count = count;
    }

    public void displayCount() {
        System.out.printf("SuperClass count = %d%n", count);
    }

}
