package com.kenfogel.arraysandcollections;

import java.util.ArrayList;
import java.util.List;

/**
 * A basic example comparing non-generic collections and generic collections.
 * The preference is always for generics.
 *
 * @author Ken Fogel
 */
public class GenericExample {

    /**
     * Using a non-generic List. This means that any object can be stored in the
     * collection
     */
    private void genericNo() {
        int numberOfApples = 9;
        String orange = "Valencia";

        List stuff = new ArrayList();
        stuff.add(numberOfApples);
        stuff.add(orange);

        System.out.printf("Stuff: %s%n", stuff);
    }

    /**
     * Using a generic List, only the generic type can be added to the List.
     */
    private void genericYes() {
        /*
         * This first value is not of the generic type String that the List is configured for
         */
        int numberOfApples = 9;
        String orange1 = "Valencia";
        String orange2 = "Navel";

        List<String> stuff = new ArrayList<>();
        stuff.add(orange1);
        stuff.add(orange2);
        // This line of code will resulkt in an exception if uncommented
        //stuff.add(numberOfApples);

        System.out.printf("Stuff: %s%n", stuff);
    }

    /**
     * This method demonstrates how to write and read a value to or from a List
     */
    private void addAndGetList() {
        String orange1 = "Valencia";
        String orange2 = "Navel";

        List<String> stuff = new ArrayList<>();
        stuff.add(orange1);
        stuff.add(orange2);

        System.out.printf("Stuff: %s%n", stuff.get(0));
        System.out.printf("Stuff: %s%n", stuff.get(1));
    }

    /**
     * Run the methods
     */
    public void perform() {
        genericNo();
        genericYes();
        addAndGetList();
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        GenericExample examples = new GenericExample();
        examples.perform();
    }
}
