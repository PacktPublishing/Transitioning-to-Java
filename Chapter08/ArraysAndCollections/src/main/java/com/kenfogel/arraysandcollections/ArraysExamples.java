package com.kenfogel.arraysandcollections;

/**
 * A basic example of how arrays are used
 *
 * @author Ken Fogel
 */
public class ArraysExamples {

    /**
     * Arrays examples
     */
    private void doArraysTests() {

        // Two ways to declare an array
        int[] quantities01 = new int[10];
        int quantities02[] = new int[10];

        // Instantiate the array with a length of 4
        String[] stuff = new String[4];
        /*
         * Arrays default to null so displaying a position in the array that has
         * not been assigned a value will result in null being displayed.
         *
         */
        System.out.printf("%s%n", stuff[0]);

        /**
         * The length of an array is a cardinal number, there are 4 places in
         * this array. We access an element using an ordinal number that begins
         * at zero. The last position in an array is always its length minus
         * one.
         */
        System.out.printf("Length: %d%n", stuff.length);
        stuff[0] = "Java";
        stuff[1] = "Python";
        stuff[2] = "JavaScript";
        stuff[3] = "C#";

        // Display using for loop
        for (int i = 0; i < stuff.length; ++i) {
            System.out.printf("Stuff %d = %s%n", i, stuff[i]);
        }

        /*
         * Display using the enhanced for loop also called foreach. We do not
         * have access to the value used in the subscript. We use this syntax
         * when we wish to access every value in an array.
         */
        for (String s : stuff) {
            System.out.printf("Stuff %s%n", s);
        }

        /*
         * Accessing an element in an array that is beyond its length-1 results
         * in an exception. Uncomment to get the exception.
         */
        // System.out.printf("Stuff 4: %s%n", stuff[4]);
        // You can use a variable as the size of an array
        int numberOfCats = 6;
        int[] cats = new int[numberOfCats];
        System.out.printf("Length: %d%n", cats.length);

    }

    /**
     * Call upon the method that demonstrates arrays
     */
    public void perform() {
        doArraysTests();
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        ArraysExamples examples = new ArraysExamples();
        examples.perform();
    }

}
