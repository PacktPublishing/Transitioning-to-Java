package com.kenfogel.adapter;

/**
 * This adapter accepts calls to the calculateUS method and then turns around
 * and calls calculateMetric in its place.
 *
 * @author Ken Fogel
 */
public class UStoMetricAdapter implements USFuelConsumption {

    private final MetricCar metric;

    public UStoMetricAdapter() {
        metric = new MetricCar();
    }

    @Override
    public String calculateUS(double distance, double volume) {
        return metric.calculateMetric(distance, volume);
    }
}
