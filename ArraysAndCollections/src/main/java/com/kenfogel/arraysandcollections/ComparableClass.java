package com.kenfogel.arraysandcollections;

/**
 * To be able to compare objects of the same type you need to implement the
 * comparable interface.
 *
 * @author Ken Fogel
 */
public class ComparableClass implements Comparable<ComparableClass> {

    /*
     * As this is an immutable value initialized in the constructor it is
     * designated as final.
     */
    private final int value;

    /**
     * The value is initialized in the constructor. This is an immutable object
     * as it does not have a means, such as a setter, to change the value.
     *
     * @param initialValue
     */
    public ComparableClass(int initialValue) {
        value = initialValue;
    }

    /**
     * A getter to return the value
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * The compareTo method must return 0 if the object being compared to has
     * the same value(s) or a negative number if the invoking object is smaller
     * or a positive number if the invoking object is larger.
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(ComparableClass o) {
        return value - o.value;
    }
}
