package com.kenfogel.openclose;

/**
 * By extending Calculation this class now has all three calculations.
 *
 * @author Ken Fogel
 */
public class Calculation2 extends Calculation {

    public void futureValueCalculator(FinancialData data) {
        var futureValue = data.getMonthlyPayment()
                * ((1 - Math.pow((1 + data.getMonthlyInterestRate()),
                        data.getMonthlyPeriods())) / data.getMonthlyInterestRate());
        data.setPrincipalAmount(futureValue);
    }

    public void savingsGoalCalculator(FinancialData data) {
        double monthlyPayment = data.getPrincipalAmount()
                * (data.getMonthlyInterestRate()
                / (1 - Math.pow((1 + data.getMonthlyInterestRate()),
                        data.getMonthlyPeriods())));
        data.setMonthlyPayment(monthlyPayment);
    }
}
