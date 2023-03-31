package com.kenfogel.virtualthreadtest;

/**
 * This class will create 5 threads of either the VirtualThreadClass or the
 * VirtualThreadRunnableInterface class
 *
 * @author Ken Fogel
 */
public class VirtualThreadRunnableInterfaceRunner {

    /**
     * Start virtual thread
     */
    public void perform() {
        for (int i = 0; i < 5; ++i) {
            // Using VirtualThreadClass
            Thread.ofVirtual().name("Thread # " + i).start(new VirtualThreadClass());
            // Using VirtualThreadRunnableInterface class
//            Thread.ofVirtual().name("Thread # " + i).start(new VirtualThreadRunnableInterface());
        }
        // Virtual threads end when the main thread ends so add some time here to let threads finish
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new VirtualThreadRunnableInterfaceRunner().perform();
    }
}
