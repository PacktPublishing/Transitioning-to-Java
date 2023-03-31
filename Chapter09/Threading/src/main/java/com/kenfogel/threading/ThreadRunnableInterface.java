package com.kenfogel.threading;

/**
 * Rather than extend Thread and blocking any other inheritence, you can use a
 * Runnable interface. It has the same run method. What you cannot do is assign
 * a name to the thread. Otherwise this is identical to ThreadClass.
 *
 * @author Ken Fogel
 */
public class ThreadRunnableInterface implements Runnable {

    // Every thread gets its own actionCounter
    private int actionCounter = 25;

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
        return "#" + Thread.currentThread().getName() + " : " + actionCounter;
    }

    /**
     * All thread classes that implement Runnable must have a run method. In this
     * run method anything you do such as call other methods or instantiate
     * objects are part of the thread. It is common to use a while(true) loop in
     * the run method.
     *
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
