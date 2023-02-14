package com.kenfogel.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class uses the ExecutorService to create a pool of threads, in this case
 * a pool of 2. As we execute threads, they are assigned to the pool. If we need
 * to assign more than 2 threads then the additional threads must wait for a
 * thread in the pool to end.
 *
 * @author Ken Fogel
 */
public class ExecutorServiceRunner {

    // Five threads
    private final int numOfThreads = 5;
    // Only 2 threads in the pool
    private final int threadPoolSize = 2;
    
    private final ExecutorService service;

    /**
     * Instantiate the ExecutorService with the pool size
     */
    public ExecutorServiceRunner() {
        service = Executors.newFixedThreadPool(threadPoolSize);
    }

    /**
     * Execute the 5 threads but 2 at a time can run
     */
    public void perform() {
        for (int i = 0; i < numOfThreads; i++) {
            service.execute(new ExecutorThreadingInterface(i));
        }
        service.shutdown();
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new ExecutorServiceRunner().perform();
    }
}
