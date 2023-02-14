package com.kenfogel.factory;

/**
 * A class to instantiate with a factory
 *
 * @author Ken Fogel
 */
public class Version01 implements SharedInterface {

    @Override
    public String whatAmI() {
        return "Version 01";
    }

    @Override
    public void perform() {
        System.out.printf("Running perform in Version 01%n");
    }
}
