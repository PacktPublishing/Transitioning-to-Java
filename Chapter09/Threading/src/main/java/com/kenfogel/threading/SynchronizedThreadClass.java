package com.kenfogel.threading;

/**
 * A class that extends Thread and calls upon an Adder method to do some work.
 * The problem will be that each thread of SynchronizedThreadClass is using the
 * same instance of Adder
 *
 * @author omniprof
 */
public class SynchronizedThreadClass extends Thread {

    private int actionCounter = 5;
    private static int threadCounter = 0;
    private final Adder adder;

    /**
     * Give a name to the thread and store a reference to Adder
     * @param adder 
     */
    public SynchronizedThreadClass(Adder adder) {
        super("" + ++threadCounter);
        this.adder = adder;
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
     * The required run method.
     */
    @Override
    public void run() {
        while (true) {
            System.out.printf("%s : %d%n", this, adder.addUp(2));
            if (--actionCounter == 0) {
                return;
            }
        }
    }
}
