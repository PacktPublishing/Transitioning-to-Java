package com.kenfogel.interfacesegregation;

/**
 *
 * @author omniprof
 */
public class Courier implements Delivery {
    private double packageSize;
    private double charge;
    
    @Override
    public void doPackageSize(int length, int height, int width) {
       packageSize = length * width * width; 
    }

    @Override
    public void doDeliveryCharge() {
        if (packageSize < 5) {
            charge = 2.0;
        } else if (packageSize < 10 ) {
            charge = 4.0;        
        } else {
            charge = 10.0;        }
    }
}
