package com.kenfogel.loggingexample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Logging Demo This demo uses the Apache log4j2 library
 *
 * @author Ken Fogel
 */
public class Log4jDemo {

    /**
     * Declare a private or protected Logger object initialized with the class's
     * name
     */
    private static final Logger LOG = LogManager.getLogger(Log4jDemo.class);

    /**
     * All LOG methods are overloaded to accept a second parameter of the
     * exception object if required.
     */
    public void perform() {
        LOG.trace("log4j2-Level 1: I am a trace");
        LOG.debug("log4j2-Level 2: I am a debug");
        LOG.info("log4j2-Level 3: I am an info");
        LOG.warn("log4j2-Level 4: I am a warning");
        try {
            throw new Exception("log4j2 exception");
        } catch (Exception ex) {
            LOG.error("log4j2-Level 5: I am an error", ex);
        }

    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new Log4jDemo().perform();
    }
}
