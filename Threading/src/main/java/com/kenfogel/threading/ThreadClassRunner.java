package com.kenfogel.threading;

/**
 * This class will create 5 threads of the ThreadClass
 *
 * @author Ken Fogel
 */
public class ThreadClassRunner {

    public void perform() {
        for (int i = 0; i < 5; i++) {
            /*
             * While a Thread class must have a run method, you use the Thread
             * method start to create and excute the thread.
             */
            new ThreadClass().start();
        }
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new ThreadClassRunner().perform();
    }
}
