package com.kenfogel.composition;

/**
 * An association between classes implies that a reference to the class is
 * passed in thru the constructor to the class it is associated with. It also
 * implies that there could be other classes with references to the associated
 * class. In this case the Association class has an association with the
 * Receiver class.
 *
 * @author Ken Fogel
 */
public class Association {

    private final Receiver receiveString;

    public Association(Receiver receiveString) {
        this.receiveString = receiveString;
    }

    public void sendMessage() {
        receiveString.displayName("Bob");
    }
}
