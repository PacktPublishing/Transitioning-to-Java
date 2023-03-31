package com.kenfogel.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author omniprof
 */
public class Deadlock1 {

    public final Object lock1 = new Object();
    public final Object lock2 = new Object();

    public void perform() {
        var t1 = new ThreadLock1(lock1, lock2);
        var t2 = new ThreadLock2(lock1, lock2);
        t1.start();
        t2.start();
    }

    public static void main(String args[]) {
        new Deadlock1().perform();
    }
}
