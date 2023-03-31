package com.kenfogel.interfaceinheritance;

/**
 * A simple record. Records are immutable so it must be instantiated with its
 * initial values.
 *
 * @author Ken Fogel
 */
public record Employee(String name, double salary) {

}
