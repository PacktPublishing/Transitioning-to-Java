package com.kenfogel.threading;

/**
 *
 * @author omniprof
 */
public class Adder {

    private long counter = 0;

    public long addUp(long value) {
        counter += value;

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return counter;
    }

    /**
     * This version of the method is synchronized so that it can finish its task
     * before another thread is switched to
     *
     * @param value
     * @return
     */
//    public long addUp(long value) {
//        synchronized (this) {
//            counter += value;
//
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//            return counter;
//        }
//    }
}
