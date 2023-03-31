package com.kenfogel.adapter;

/**
 * Calculate MPG
 *
 * @author Ken Fogel
 */
public class USCar implements USFuelConsumption {

    @Override
    public String calculateUS(double distance, double volume) {
        return "MPG = " + distance / volume;
    }

}
