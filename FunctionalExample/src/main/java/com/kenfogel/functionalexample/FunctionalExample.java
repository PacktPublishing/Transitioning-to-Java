package com.kenfogel.functionalexample;

/**
 * A functional interface uses an interface class with only one method.
 *
 * @author omniprof
 * @param <T>
 * @param <U>
 */
@FunctionalInterface
interface Multiplier<T, U> {
    int multiply(T a, U b);
}

/**
 * In this example we look at how we can pass a function to a method or have a
 * method return a function
 *
 * @author Ken Fogel
 */
public class FunctionalExample {

    // Higher-Order 1: Function accepts a function as an argument
    private int execute(Multiplier<Integer, Integer> multiplier) {
        return multiplier.multiply(5, 10);
    }

    // Higher-Order 2: Function returns another function
    private Multiplier<Integer, Integer> getMultiplier() {
        // First-Class 1: Function assigned to a variable
        Multiplier<Integer, Integer> multiplier = (a, b) -> a * b;

        // First-Class 3: Function returned from a function
        return multiplier;
    }

    /**
     * Using the functions
     */
    public void perform() {
        // Receive a function from a method
        Multiplier<Integer, Integer> multiplier = getMultiplier();

        // Pass a function to a method
        int ans = execute(multiplier);

        System.out.println(ans);
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new FunctionalExample().perform();
    }
}
