package com.kenfogel.composition;

/**
 * This class demonstrates Aggregation and Association
 *
 * @author Ken Fogel
 */
public class Composition {

    public void perform() {
        var receive = new Receiver();
        var associate = new Association(receive);
        associate.sendMessage();
        receive.displayName("Ken");
        var aggregate = new Aggregation();
        aggregate.sendMessage();
    }

    public static void main(String[] args) {
        new Composition().perform();
    }

}
