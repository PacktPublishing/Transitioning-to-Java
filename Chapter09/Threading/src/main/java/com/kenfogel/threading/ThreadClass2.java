package com.kenfogel.threading;

/**
 * A basic thread identrical to ThreadClass for use in the JoinExample.
 *
 * @author Ken Fogel
 */
public class ThreadClass2 extends Thread {

    // Every thread gets its own actionCounter
    private int actionCounter = 500;
    /**
     * A static variable shared by all threads, useful if you wish to name the
     * thread. many threads are created.
     */
    private static int threadCounter = 1;

    /**
     * Increment the threadCounter everytime a thread is created and use the
     * counter as the thread name
     */
    public ThreadClass2() {
        super("" + ++threadCounter);
    }

    /**
     * Overloading toString allows us to display the thread's name and the
     * current state of the thread's counter
     *
     * @return
     */
    @Override
    public String toString() {
        return "#" + getName() + " : " + actionCounter;
    }

    /**
     * All thread classes that extend Thread must have a run method. In this run
     * method anything you do such as call other methods or instantiate objects
     * are part of the thread. It is common to use a while(true) loop in the run
     * method.
     *
     */
    @Override
    public void run() {
        while (true) {
            System.out.printf("tc2: %s%n", this);
            if (--actionCounter == 0) {
                return;
            }
        }
    }
}
