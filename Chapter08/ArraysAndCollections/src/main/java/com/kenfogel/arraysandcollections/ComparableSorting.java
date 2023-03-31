package com.kenfogel.arraysandcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class creates a List of ComparableClass objects, filling each with a
 * random integer that will form the basis of the sort order. To support sorting
 * in a collection you must have objects that implement the Comparable interface
 *
 * @author Ken Fogel
 */
public class ComparableSorting {

    /**
     * Immutable List object. In this case it is the reference to the List that
     * cannot change but the elements in the list can be changed.
     */
    private final List<ComparableClass> comparableClasses;

    /**
     * As the comparableClasses is final it must be instantiated in the
     * constructor.
     */
    public ComparableSorting() {
        comparableClasses = new ArrayList<>();
    }

    /**
     * Fill the list with ComparableClass objects initialized with a random
     * number
     */
    private void fillList() {
        Random rand = new Random();
        int upperBound = 25;
        System.out.printf("Unsorted:%n");
        for (int i = 0; i < 10; ++i) {
            comparableClasses.add(new ComparableClass(rand.nextInt(upperBound)));
        }
        System.out.printf("%n");
    }

    /**
     * Display the List
     */
    private void displayList() {
        for (int i = 0; i < 10; ++i) {
            System.out.printf("%s ", comparableClasses.get(i).getValue());
        }
        System.out.printf("%n");
    }

    /**
     * Creates a list, displays it, sorts it, and displays it again.
     */
    public void perform() {
        fillList();
        displayList();
        Collections.sort(comparableClasses);
        displayList();
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        ComparableSorting examples = new ComparableSorting();
        examples.perform();
    }
}
