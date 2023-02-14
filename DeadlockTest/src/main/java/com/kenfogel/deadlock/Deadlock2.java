package com.kenfogel.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * In this example we are using objects of type ReentrantLock as locks but
 * deadlock remains a possibility
 *
 * @author Ken Fogel
 */
public class Deadlock2 {

    public final Lock lock1 = new ReentrantLock();
    public final Lock lock2 = new ReentrantLock();

    public void perform() {
        var t1 = new ThreadLock1a(lock1, lock2);
        var t2 = new ThreadLock2a(lock1, lock2);
        t1.start();
        t2.start();
    }

    public static void main(String args[]) {
        new Deadlock2().perform();
    }

}
