package com.kenfogel.openclose;

/**
 * Each calculation class implements this interface. New calculations just need
 * to impelment this interface
 *
 * @author Ken Fogel
 */
public interface FinanceCalculate {

    void determine(FinancialData data);
}
