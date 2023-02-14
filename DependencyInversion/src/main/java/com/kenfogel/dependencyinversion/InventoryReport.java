package com.kenfogel.dependencyinversion;

/**
 * With Dependency Inversion we can pass any item that implements the Inventory
 * interface.
 *
 * @author Ken Fogel
 */
public class InventoryReport {

    private final Inventory inventoryData;

    public InventoryReport(Inventory data) {
        inventoryData = data;
    }

    public void displayReport() {
        System.out.printf("Description: %s  Stock: %d%n",
                inventoryData.getDescription(),
                inventoryData.getStockAmount());
    }
}
