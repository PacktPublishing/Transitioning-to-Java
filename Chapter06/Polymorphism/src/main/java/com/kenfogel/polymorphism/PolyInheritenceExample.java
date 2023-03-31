package com.kenfogel.polymorphism;

/**
 * Example of polymorphism with a superclass
 *
 * @author Ken Fogel
 */
public class PolyInheritenceExample {

    /**
     * This method will accept any object with this superclass
     *
     * @param sc
     */
    private void show(SuperClass sc) {
        sc.setCount(42);
        sc.displayCount();
    }

    public void perform() {
        var subClass = new SubClass();
        show(subClass);
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new PolyInheritenceExample().perform();
    }
}
