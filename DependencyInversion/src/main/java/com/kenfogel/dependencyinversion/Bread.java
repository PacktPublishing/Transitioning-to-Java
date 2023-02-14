package com.kenfogel.dependencyinversion;

/**
 * In Dependency Inversion it is prefered that you have an interface for the
 * class that this class does not have.
 *
 * @author Ken Fogel
 */
public class Bread {

    private String description;
    private int stockAmount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

}
