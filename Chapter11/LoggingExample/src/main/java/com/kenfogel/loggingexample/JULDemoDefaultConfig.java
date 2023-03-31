package com.kenfogel.loggingexample;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logging Demo This demo uses the Java SE java.util.logging library
 *
 * @author Ken Fogel
 */
public class JULDemoDefaultConfig {

    private static final Logger LOG = Logger.getLogger(JULDemoDefaultConfig.class.getName());

    /**
     * Using the logger
     */
    public void perform() {
        /*
          Level is the first parameter, the message you compose is the second
          parameter, and the optional third parameter is an exception object.
         */
        LOG.log(Level.FINEST, "JUL default-Using LOG.log at Level.FINEST");
        LOG.log(Level.FINER, "JUL default-Using LOG.log at Level.FINER");
        LOG.log(Level.FINE, "JUL default-Using LOG.log at Level.FINE");
        LOG.log(Level.INFO, "JUL default-Using LOG.log at Level.INFO");
        LOG.log(Level.WARNING, "JUL default-Using LOG.log at Level.WARNING");
        try {
            throw new Exception("JUL default config exception");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "JUL default-Using LOG.log at Level.SEVERE", ex);
        }
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new JULDemoDefaultConfig().perform();
    }
}
