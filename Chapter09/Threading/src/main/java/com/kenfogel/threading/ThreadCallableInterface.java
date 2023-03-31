package com.kenfogel.threading;

import java.util.concurrent.Callable;

/**
 * The Callable interface is similar to Runnable. What it adds is that a thread
 * can return a value when it completes its task. The data type that is returned
 * is expressed in generic notation. It can only be used with the
 * ExecutorService.
 *
 * @author Ken Fogel
 */
public class ThreadCallableInterface implements Callable<String> {

    // Every thread gets its own actionCounter
    private int actionCounter = 250;
    // The thread count number assigned when the the thread is instantiated
    private final int threadCount;

    /**
     * Each thread is assigned a value when created and that value is passed to
     * the thread and saved. Every thread will get a unique number.
     *
     * @param count
     */
    public ThreadCallableInterface(int count) {
        threadCount = count;
    }

    /**
     * Overloading toString allows us to display the thread's name and the
     * current state of the thread's counter. Unlike extending Thread to access
     * the getName() method we call upon a static method in the Thread class to
     * get this information.
     *
     * @return
     */
    @Override
    public String toString() {
        return "#" + Thread.currentThread().getName() + "-" + threadCount + " : " + actionCounter;

    }

    /**
     * Rather than using run, we use call. The call method is expected to return
     * a value of the type defined when we implemented Callable.
     *
     * @return
     */
    @Override
    public String call() {
        while (true) {
            System.out.printf("%s%n", this);
            if (--actionCounter == 0) {
                return "Thread # " + threadCount + " is finished";
            }
        }
    }
}
