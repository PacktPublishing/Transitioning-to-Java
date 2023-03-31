package com.kenfogel.composition;

/**
 * In an aggregation one class instantiates another class. This implies that the
 * aggregated class, in this case Receiver, is unique to the aggregating class,
 * Aggregation. Each instance of the aggregating class instantiates a unique
 * instance of the aggregated class.
 *
 * @author omniprof
 */
public class Aggregation {

    private final Receiver receiveString;

    public Aggregation() {
        receiveString = new Receiver();
    }

    public void sendMessage() {
        receiveString.displayName("Bob");
    }
}
