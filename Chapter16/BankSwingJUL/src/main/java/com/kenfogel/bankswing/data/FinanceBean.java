package com.kenfogel.bankswing.data;

import java.math.BigDecimal;

/**
 * This is a plain Java Bean that holds four BigDecimal objects.
 *
 * Logging changed to JUL from log4j2 
 *
 * @author Ken Fogel
 */
public class FinanceBean {

    private BigDecimal inputValue;
    private BigDecimal rate;
    private BigDecimal term;
    private BigDecimal result;

    /**
     * Default constructor that does not take any parameters
     */
    public FinanceBean() {
        this(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    /**
     * Non-default constructor that expects three parameters. These are
     * BigDecimals that can be assigned to the local class references.
     *
     * @param inputValue
     * @param rate
     * @param term
     */
    public FinanceBean(BigDecimal inputValue,
            BigDecimal rate, BigDecimal term) {
        this.inputValue = inputValue;
        this.rate = rate;
        this.term = term;
        this.result = BigDecimal.ZERO;
    }

    /**
     * Getter
     *
     * @return result
     */
    public BigDecimal getResult() {
        return result;
    }

    /**
     * Setter
     *
     * @param result The new value
     */
    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public BigDecimal getInputValue() {
        return inputValue;
    }

    public void setInputValue(BigDecimal inputValue) {
        this.inputValue = inputValue;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getTerm() {
        return term;
    }

    public void setTerm(BigDecimal term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "FinanceBean{" + "inputValue=" + inputValue
                + ", rate=" + rate + ", term=" + term
                + ", result=" + result + '}';
    }

}
