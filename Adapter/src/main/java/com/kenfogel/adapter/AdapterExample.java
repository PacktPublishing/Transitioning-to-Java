package com.kenfogel.adapter;

/**
 * This basic example shows how an adaptor can be used
 *
 * @author Ken Fogel
 */
public class AdapterExample {

    // 
    private final USFuelConsumption consumption;

    public AdapterExample() {
        consumption = new UStoMetricAdapter();
    }

    public void perform() {
        System.out.printf("%s%n", consumption.calculateUS(350.0, 44.0));

    }

    public static void main(String[] args) {
        new AdapterExample().perform();
    }
}
