package com.kenfogel.polymorphism;

/**
 * Example of polymorphism with an interface class
 *
 * @author Ken Fogel
 */
public class PolyInterfaceExample {

    /**
     * This method will accept any object that implements the Interface
     *
     * @param face
     */
    private void show(Interface face) {
        face.displayCount();
    }

    public void perform() {
        var implement = new Implementation();
        implement.setCount(42);
        show(implement);
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new PolyInterfaceExample().perform();
    }

}
