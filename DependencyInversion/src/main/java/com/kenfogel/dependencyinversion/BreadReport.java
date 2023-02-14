package com.kenfogel.dependencyinversion;

/**
 * This report class requires the specific Bread class
 *
 * @author Ken Fogel
 */
public class BreadReport {

    private final Bread breadData;

    public BreadReport(Bread data) {
        breadData = data;
    }

    public void displayReport() {
        System.out.printf("Description: %s  Stock: %d%n", breadData.getDescription(), breadData.getStockAmount());
    }
}
