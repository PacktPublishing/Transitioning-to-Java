package com.kenfogel.dependencyinversion;

/**
 * Here we are using an interface class
 *
 * @author Ken Fogel
 */
public class MilkDI implements Inventory{
    private String description;
    private int stockAmount;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getStockAmount() {
        return stockAmount;
    }

    @Override
    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
