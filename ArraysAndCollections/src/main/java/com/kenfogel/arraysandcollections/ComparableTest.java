package com.kenfogel.arraysandcollections;

/**
 * A basic example of comparing objects of the same type that implement the
 * Comparable interface
 *
 * @author Ken Fogel
 */
public class ComparableTest {

    // Two immutable ComparableClass objects
    private final ComparableClass comparable01;
    private final ComparableClass comparable02;

    /**
     * Instantiate and initialized the ComparableClass objects
     *
     * @param value1
     * @param value2
     */
    public ComparableTest(int value1, int value2) {
        comparable01 = new ComparableClass(value1);
        comparable02 = new ComparableClass(value2);
    }

    /**
     * The results of comparing the two objects
     */
    public void perform() {
        System.out.printf("comparable01 compared to comparable02 %d%n",
                comparable01.compareTo(comparable02));
        System.out.printf("comparable02 compared to comparable01 %d%n",
                comparable02.compareTo(comparable01));
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        ComparableTest examples = new ComparableTest(12, 2);
        examples.perform();
    }
}
