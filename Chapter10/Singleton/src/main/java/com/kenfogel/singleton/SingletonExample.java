package com.kenfogel.singleton;

/**
 * A simple class that instantiates the two types of Singletons twice and then
 * demonstrates that both instances are the same.
 *
 * @author Ken Fogel
 */
public class SingletonExample {

    public void perform() {
        var myInstance1 = Singleton.getInstance();
        var myInstance2 = Singleton.getInstance();

        var myInstance3 = SingletonSafe.getInstance();
        var myInstance4 = SingletonSafe.getInstance();

        /**
         * We can use == on the objects because we want to compare their address
         * and not their contents.
         */
        if (myInstance1 == myInstance2) {
            System.out.printf("Objects are the same%n");
        } else {
            System.out.printf("Objects are different%n");
        }

        if (myInstance3 == myInstance4) {
            System.out.printf("Safe: Objects are the same%n");
        } else {
            System.out.printf("Safe: Objects are different%n");
        }
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new SingletonExample().perform();
    }
}
