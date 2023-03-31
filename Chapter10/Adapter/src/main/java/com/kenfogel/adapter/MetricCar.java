package com.kenfogel.adapter;

/**
 * Calculate liters per 100 km
 *
 * @author Ken Fogel
 */
public class MetricCar implements MetricFuelConsumptions {

    @Override
    public String calculateMetric(double distance, double volume) {
        return "l/100km = " + volume / distance * 100;
    }

}
