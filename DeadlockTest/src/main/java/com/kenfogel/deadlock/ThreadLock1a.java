package com.kenfogel.deadlock;

import java.util.concurrent.locks.Lock;

/**
 * Example of a deadlock using Lock objects
 *
 * @author Ken Fogel
 */
public class ThreadLock1a extends Thread {

    private final Lock lock1;
    private final Lock lock2;
    
    /**
     * Use the Lock type for a lock
     *
     * @param lock1
     * @param lock2
     */
    public ThreadLock1a(Lock lock1, Lock lock2) {
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

        lock1.lock();
        System.out.printf("Thread 1a: Holding lock 1%n");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        System.out.printf("Thread 1a: Waiting for lock 2%n");

        lock2.lock();
        System.out.printf("Thread 1a: Holding lock 1 & 2");
        lock2.unlock();

        lock1.unlock();
    }

}
