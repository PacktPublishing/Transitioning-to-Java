package com.kenfogel.threading;

/**
 * This the thread that we wish to pool with the ExecutorService
 *
 * @author Ken Fogel
 */
public class ExecutorThreadingInterface implements Runnable {

    private int actionCounter = 25;
    private final int threadCount;

    /**
     * Each thread is assigned a value when created and that value is passed to
     * the thread and saved. Every thread will get a unique number.
     *
     * @param count
     */
    public ExecutorThreadingInterface(int count) {
        threadCount = count;
    }

    /**
     * Overloading toString allows us to display:
     *
     * Pool size and thread name
     *
     * Number of threads in the pool
     *
     * Current thread number action counter value
     *
     * @return
     */
    @Override
    public String toString() {
        return "#" + Thread.currentThread().getName() + "-" + threadCount + " : " + actionCounter;
    }

    /**
     * Each thread of this class starts here
     */
    @Override
    public void run() {
        while (true) {
            System.out.printf("%s%n", this);
            if (--actionCounter == 0) {
                return;
            }
        }
    }
}
