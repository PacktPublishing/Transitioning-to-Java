package com.kenfogel.deadlock;

/**
 * Example of a deadlock using Object as the lock
 *
 * @author Ken Fogel
 */
public class ThreadLock1 extends Thread {

    private final Object lock1;
    private final Object lock2;

    /**
     * Use the Object type for a lock
     *
     * @param lock1
     * @param lock2
     */
    public ThreadLock1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    /**
     * This thread, Thread1, uses lock1 and then lock2. When Thread2 reverses
     * the order we get deadlock. Change Thread2 to use the locks in the same
     * order as Thread1 and this will eliminate the deadlock.
     */
    @Override
    public void run() {
        synchronized (lock1) {
            System.out.printf("Thread 1: Holding lock 1%n");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Thread 1: Waiting for lock 2%n");

            synchronized (lock2) {
                System.out.printf("Thread 1: Holding lock 1 & 2%n");
            }
        }
    }
}
