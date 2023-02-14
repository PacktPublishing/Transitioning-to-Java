package com.kenfogel.deadlock;

import java.util.concurrent.locks.Lock;

/**
 * Example of a deadlock using Lock objects
 *
 * @author Ken Fogel
 */
public class ThreadLock2a extends Thread {
    private final Lock lock1;
    private final Lock lock2;
    
    /**
     * Use the Lock type for a lock
     *
     * @param lock1
     * @param lock2
     */
    public ThreadLock2a(Lock lock1, Lock lock2) {
       this.lock1 = lock1;
       this.lock2 = lock2;
    }

    /**
     * You can solve deadlock in this method by changing the order of locks to
     * match Thread1.
     */
    @Override
    public void run() {
        
        lock2.lock();
        System.out.println("Thread 2a: Holding lock 2");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        System.out.println("Thread 2a: Waiting for lock 1");

        lock1.lock();
        System.out.println("Thread 2a: Holding lock 1 & 2");
        lock1.unlock();
       
        lock2.unlock();
    }
}
