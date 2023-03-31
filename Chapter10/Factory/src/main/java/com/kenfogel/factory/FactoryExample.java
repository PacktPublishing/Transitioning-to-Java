package com.kenfogel.factory;

/**
 * Rather than use new, we use a static method in the class to instantiate it.
 *
 * @author Ken Fogel
 */
public class FactoryExample {

    private SharedInterface version;

    public void perform(String versionName) {
        version = Factory.getInstance(versionName);
        System.out.printf("Version: %s%n", version.whatAmI());
        version.perform();
    }

    public static void main(String[] args) {
        new FactoryExample().perform("version01");
        new FactoryExample().perform("version02");
    }
}
