package com.kenfogel.compoundinterest05.data;

public class CompoundInterestData05 {
    
    private final double principal;
    private final double annualInterestRate;
    private final double compoundPerTimeUnit;
    private final double time;
    private double result;

    public CompoundInterestData05(double principal, double annualInterestRate, double compoundPerTimeUnit, double time) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.compoundPerTimeUnit = compoundPerTimeUnit;
        this.time = time;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getCompoundPerTimeUnit() {
        return compoundPerTimeUnit;
    }

    public double getTime() {
        return time;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
