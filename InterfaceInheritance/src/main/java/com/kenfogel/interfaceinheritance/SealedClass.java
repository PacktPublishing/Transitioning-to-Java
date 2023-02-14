package com.kenfogel.interfaceinheritance;

/**
 * Here we are declaring that only a class named SubClass may extend this class. 
 *
 * @author Ken Fogel
 */
public sealed class SealedClass permits SubClass {
}
