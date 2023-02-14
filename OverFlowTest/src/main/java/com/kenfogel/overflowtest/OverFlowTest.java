package com.kenfogel.overflowtest;

/**
 * Examples of overflow and underflow.
 *
 * @author Ken Fogel
 */
public class OverFlowTest {

    public void perform() {

        short testValue1 = (short) 32768;
        System.out.printf("testValue1 = %d\n", testValue1);

        double testValue2 = Double.MAX_VALUE + Double.MAX_VALUE;
        System.out.printf("testValue2 = %f\n", testValue2);

        double testValue3 = Double.MAX_VALUE + 1.0;
        System.out.printf("testValue3 = %f\n", testValue3);

        double testValue4 = Double.MAX_VALUE;
        System.out.printf("testValue4 = %f\n", testValue4);

        double testValue5 = Double.MIN_VALUE;
        System.out.printf("testValue5 = %2.16e\n", testValue5);

        double testValue6 = Double.MIN_VALUE / 2;
        System.out.printf("testValue6 = %2.16e\n", testValue6);

    }

    public static void main(String[] args) {
        var overflow = new OverFlowTest();
        overflow.perform();
    }
}
