package com.kenfogel.openclose;

/**
 * The FutureValue class that implements FinanceCalculate. This allows an object
 * of this type used where ever an object that implements FinanceCalculate is
 * used.
 *
 * @author Ken Fogel
 */
public class FutureValue implements FinanceCalculate {

    @Override
    public void determine(FinancialData data) {
        var futureValue = data.getMonthlyPayment()
                * ((1 - Math.pow((1 + data.getMonthlyInterestRate()),
                        data.getMonthlyPeriods())) / data.getMonthlyInterestRate());
        data.setPrincipalAmount(futureValue);
    }
}
