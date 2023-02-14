package com.kenfogel.interfacesegregation;

/**
 *
 * @author omniprof
 */
public interface Delivery {
    void doPackageSize(int length, int height, int width);
    void doDeliveryCharge();
}
