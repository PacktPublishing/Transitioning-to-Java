package com.kenfogel.factory;

/**
 * A class to instantiate with a factory
 *
 * @author Ken Fogel
 */
public class Version02 implements SharedInterface {

    @Override
    public String whatAmI() {
        return "Version 02";
    }

    @Override
    public void perform() {
        System.out.printf("Running perform in Version 02%n");
    }
    
}
