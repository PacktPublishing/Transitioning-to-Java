package com.kenfogel.openclose;

/**
 * The LoanPayment class that implements FinanceCalculate. This allows an object
 * of this type used where ever an object that implements FinanceCalculate is
 * used.
 *
 * @author Ken Fogel
 */
public class LoanPayment implements FinanceCalculate {

    @Override
    public void determine(FinancialData data) {
        var monthlyPayment = data.getPrincipalAmount()
                * (data.getMonthlyInterestRate() / (1 - Math.pow(
                (1 + data.getMonthlyInterestRate()), -data.getMonthlyPeriods())));
        data.setMonthlyPayment(monthlyPayment);
    }
}
