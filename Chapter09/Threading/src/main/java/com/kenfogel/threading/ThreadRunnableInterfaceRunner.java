package com.kenfogel.threading;

/**
 * This class will create 5 threads of the ThreadRunnableInterface class
 *
 * @author Ken Fogel
 */
public class ThreadRunnableInterfaceRunner {

    public void perform() {
        System.out.printf("implements Runnable%n");
        for (int i = 0; i < 5; i++) {
            /**
             * We cannot call the start() method when a thread implements
             * runnable. Instead we instantiate a new Thread and pass to its
             * constructor a reference to a Runnable thread and the thread name.
             * Now we can call start().
             */
            new Thread(new ThreadRunnableInterface(), "" + i).start();
        }
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new ThreadRunnableInterfaceRunner().perform();
    }
}
