package com.kenfogel.openclose;

/**
 * The SavingsGoal class that implements FinanceCalculate. This allows an object
 * of this type used where ever an object that implements FinanceCalculate is
 * used.
 *
 * @author Ken Fogel
 */
public class SavingsGoal implements FinanceCalculate {

    @Override
    public void determine(FinancialData data) {
        double monthlyPayment = data.getPrincipalAmount()
                * (data.getMonthlyInterestRate()
                / (1 - Math.pow((1 + data.getMonthlyInterestRate()),
                        data.getMonthlyPeriods())));
        data.setMonthlyPayment(monthlyPayment);
    }
}
