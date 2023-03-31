package com.kenfogel.liskov;

/**
 * A subclass that extends SuperClass
 *
 * @author Ken Fogel
 */
public class SubClass extends SuperClass {

    public void display(String name, int age) {
        System.out.printf("Welcome to Java %s at age %d%n", name, age);

    }
}
