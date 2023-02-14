package com.kenfogel.threading;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * This example shows how we use threads that implement the Callable interface.
 * As we cannot predict the order of the threads when they complete, we assign
 * their return value to a List of Future objects.
 *
 * @author Ken Fogel
 */
public class ThreadCallableInterfaceRunner {

    private final List<Future<String>> futureList;
    private final ExecutorService executor;

    private final int numOfThreads = 5;
    private final int threadPoolSize = 2;
    private final DateTimeFormatter dtf;

    /**
     * Create the ExecutorService, an array list to hold Future objects, and a
     * date formatter for pretty printing the date.
     */
    public ThreadCallableInterfaceRunner() {
        executor = Executors.newFixedThreadPool(threadPoolSize);
        futureList = new ArrayList<>();
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    }

    /**
     * Here we use submit to hand over a thread to the ExecutorService as it
     * returns a value of type Future.
     */
    public void perform() {
        // This loop ends after the last thread finishes executing
        for (int i = 0; i < numOfThreads; i++) {
            Future<String> future = executor.submit(new ThreadCallableInterface(i));
            futureList.add(future);
        }

        // Display the returned value from each thread stored in a Future object
        for (Future<String> futureResult : futureList) {
            try {
                System.out.println(dtf.format(LocalDateTime.now()) + "::" + futureResult.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new ThreadCallableInterfaceRunner().perform();
    }

}
