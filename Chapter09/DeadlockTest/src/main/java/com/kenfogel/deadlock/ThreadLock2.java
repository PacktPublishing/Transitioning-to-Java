package com.kenfogel.deadlock;

/**
 * Example of a deadlock using Object as the lock
 *
 * @author Ken Fogel
 */
public class ThreadLock2 extends Thread {

    private final Object lock1;
    private final Object lock2;

    /**
     * Use the Object type for a lock
     *
     * @param lock1
     * @param lock2
     */
    public ThreadLock2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    /**
     * You can solve deadlock in this method by changing the order of locks to
     * match Thread1.
     */
    @Override
    public void run() {
        synchronized (lock2) {
            System.out.printf("Thread 2: Holding lock 2%n");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.printf("Thread 2: Waiting for lock 1%n");

            synchronized (lock1) {
                System.out.printf("Thread 2: Holding lock 1 & 2%n");
            }
        }
    }

}
