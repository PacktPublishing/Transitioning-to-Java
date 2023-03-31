package com.kenfogel.loggingexample;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Logging Demo This demo uses the Java SE java.util.logging library
 *
 * @author Ken Fogel
 */
public class JULDemoCustomConfig {

    private static final Logger LOG;

    // Set up the java.util.logging with a custom logging.properties to replace 
    // the default one found in the conf folder of your Java install.
    // Changes to this config file will be used by JUL if the following code that
    // loads an application specific config is not used.
    static {

        try (InputStream is = retrieveURLOfJarResource("logging.properties").openStream()) {
            LogManager.getLogManager().readConfiguration(is);
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe("Unable to load logging.properties\nProgram is exiting");
            System.exit(1);
        }
        LOG = Logger.getLogger(JULDemoCustomConfig.class.getName());
    }

    /**
     * This supports accessing the logging.properties file stored in the
     * resource folder of the jar file
     *
     * @param resourceName
     * @return
     */
    public static java.net.URL retrieveURLOfJarResource(String resourceName) {
        return Thread.currentThread().getContextClassLoader().getResource(resourceName);
    }

    /**
     * Here we are using the two ways to create a LOG message.
     */
    public void perform() {
        /*
          Level is the first parameter, the message you compose is the second
          parameter, and the optional third parameter is an exception object.
         */
        LOG.log(Level.FINEST, "JUL custom-Using LOG.log at Level.FINEST");
        LOG.log(Level.FINER, "JUL custom-Using LOG.log at Level.FINER");
        LOG.log(Level.FINE, "JUL custom-Using LOG.log at Level.FINE");
        LOG.log(Level.INFO, "JUL custom-Using LOG.log at Level.INFO");
        LOG.log(Level.WARNING, "JUL custom-Using LOG.log at Level.WARNING");
        try {
            throw new Exception("JUL custom config exception");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "JUL custom-Using LOG.log at Level.SEVERE", ex);
        }

    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new JULDemoCustomConfig().perform();
    }
}
