package com.kenfogel.threading;

/**
 * This class demonstartes howw e canm use join to wait for another thread to
 * finish
 *
 * @author Ken Fogel
 */
public class ThreadClass1 extends Thread {

    private int actionCounter = 500;
    private static int threadCounter = 0;
    private final ThreadClass2 tc2;

    public ThreadClass1() {
        super("" + ++threadCounter);
        tc2 = new ThreadClass2();
    }

    @Override
    public String toString() {
        return "#" + getName() + " : " + actionCounter;
    }

    /**
     * We are starting ThreadClass2 inside ThreadClass1. This allows us to use
     * join on a thread we want to wait for completion before continuing.
     */
    @Override
    public void run() {
        tc2.start();
        while (true) {
            System.out.printf("tc1: %s%n", this);
            /*
             * When the counter for this object reaches 225 it will then wait
             * for tc2 to finish before it continues
             */
            if (actionCounter == 225) {
                try {
                    tc2.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            if (--actionCounter == 0) {
                return;
            }
        }
    }
}
