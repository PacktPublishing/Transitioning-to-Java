package com.kenfogel.dependencyinversion;

/**
 * The Inventory interface class
 *
 * @author Ken Fogel
 */
public interface Inventory {

    public String getDescription();

    public void setDescription(String description);

    public int getStockAmount();

    public void setStockAmount(int stockAmount);
}
