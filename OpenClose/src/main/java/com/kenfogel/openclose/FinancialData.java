package com.kenfogel.openclose;

/**
 * Here is our data bean
 *
 * @author Ken Fogel
 */
public class FinancialData {

    private double principalAmount;
    private double monthlyInterestRate;
    private double monthlyPeriods;
    private double monthlyPayment;

    public FinancialData() {
        this(0.0, 0.0, 0.0, 0.0);
    }

    public FinancialData(double principle, double interest, double periods, double payment) {
        this.principalAmount = principle;
        this.monthlyInterestRate = interest;
        this.monthlyPeriods = periods;
        this.monthlyPayment = payment;
    }

    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    public void setMonthlyInterestRate(double monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getMonthlyPeriods() {
        return monthlyPeriods;
    }

    public void setMonthlyPeriods(double monthlyPeriods) {
        this.monthlyPeriods = monthlyPeriods;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }
}
