package com.kenfogel.threading;

/**
 * This example demonstrates what can happen when two threads each use an
 * isnatnce of the same object, in this example the Adder class.As each thread
 * uses Adder its time slice may end and the second thread now has acces to the
 * same instance of the Adder object. This is called a Race condition.
 *
 * There are two metrhods in Addre named addUp. The first is used for the
 * ThreadClassRunner. Watch what happens if we leave this one in place. Then
 * comment out the first addUp and uncomment the second addUp.
 *
 * @author omniprof
 */
public class SynchronizedExample {

    private final SynchronizedThreadClass tc1;
    private final SynchronizedThreadClass tc2;
    private final Adder sa;

    /**
     * Each class that extends Thread uses the same reference to an Adder object
     */
    public SynchronizedExample() {
        sa = new Adder();
        tc1 = new SynchronizedThreadClass(sa);
        tc2 = new SynchronizedThreadClass(sa);
    }

    /**
     * We start each thread
     */
    public void perform() {
        tc1.start();
        tc2.start();
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new SynchronizedExample().perform();
    }
}
