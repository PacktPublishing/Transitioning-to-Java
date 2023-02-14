package com.kenfogel.openclose;

/**
 * Here is the loanCalculator. To add new functionality we do NOT add code to
 * this working class. Instead we create a new class, Calculation2, that has the
 * additional methods and extends this class.
 *
 * @author Ken Fogel
 */
public class Calculation {

    public void loanCalculator(FinancialData data) {
        var monthlyPayment = data.getPrincipalAmount()
                * (data.getMonthlyInterestRate() / (1 - Math.pow(
                (1 + data.getMonthlyInterestRate()), -data.getMonthlyPeriods())));
        data.setMonthlyPayment(monthlyPayment);
    }
}
