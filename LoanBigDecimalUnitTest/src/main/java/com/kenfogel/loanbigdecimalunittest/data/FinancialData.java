package com.kenfogel.loanbigdecimalunittest.data;

import java.math.BigDecimal;

/**
 * The data class used by Calculation
 *
 * @author Ken Fogel
 */
public class FinancialData {

    private BigDecimal amountBorrowed;
    private BigDecimal annualRate;
    private BigDecimal term;
    private BigDecimal monthlyPayment;

    public FinancialData(BigDecimal amountBorrowed,
            BigDecimal annualRate,
            BigDecimal term) {

        this.amountBorrowed = amountBorrowed;
        this.annualRate = annualRate;
        this.term = term;
        this.monthlyPayment = BigDecimal.ZERO;
    }

    public FinancialData() {
        this(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    public BigDecimal getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(BigDecimal annualRate) {
        this.annualRate = annualRate;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public BigDecimal getTerm() {
        return term;
    }

    public void setTerm(BigDecimal term) {
        this.term = term;
    }

    public BigDecimal getAmountBorrowed() {
        return amountBorrowed;
    }

    public void setAmountBorrowed(BigDecimal amountBorrowed) {
        this.amountBorrowed = amountBorrowed;
    }

    @Override
    public String toString() {
        return "FinancialData{" + "amountBorrowed=" + amountBorrowed + ", annualRate=" + annualRate + ", term=" + term + ", monthlyPayment=" + monthlyPayment + '}';
    }
}
