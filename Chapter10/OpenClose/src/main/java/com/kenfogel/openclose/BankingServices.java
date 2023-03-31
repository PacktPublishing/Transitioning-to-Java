package com.kenfogel.openclose;

/**
 * Using polymorphism we can pass any object that implements the
 * FinanceCalculate interface
 *
 * @author Ken Fogel
 */
public class BankingServices {

    public void doCalculation(FinanceCalculate process, FinancialData data) {
        if (process == null || data == null) {
            throw new IllegalArgumentException("Invalid parameter");
        }
        process.determine(data);
    }
}
