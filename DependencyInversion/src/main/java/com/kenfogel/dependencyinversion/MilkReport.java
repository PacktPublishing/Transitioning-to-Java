package com.kenfogel.dependencyinversion;

/**
 * This report class requires the specific Milk class
 *
 * @author Ken Fogel
 */
public class MilkReport {
    
    private final Milk milkData;
    
    public MilkReport(Milk data) {
        milkData = data;
    }
    
    public void displayReport() {
        System.out.printf("Description: %s  Stock: %d%n", milkData.getDescription(), milkData.getStockAmount());
    }
    
}
