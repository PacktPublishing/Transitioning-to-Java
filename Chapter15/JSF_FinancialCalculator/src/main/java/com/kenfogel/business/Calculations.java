package com.kenfogel.business;

import com.kenfogel.data.FinanceBean;
import jakarta.enterprise.context.RequestScoped;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * This class contains the calculations
 *
 * @author Ken Fogel
 */
@Named("calculate")
@RequestScoped
public class Calculations implements Serializable {

    private static final Logger LOG = Logger.getLogger(Calculations.class.getName());
    /*
     * The curremt instance of the data bean managed by CDI
     */
    @Inject
    FinanceBean money;

    /**
     * Based on the calculationType in the bean, select the appropriate
     * calculation and return the result as a String
     *
     * @return
     */
    public String performCalculation() {
        switch (money.getCalculationType()) {
            case "loan" ->
                loanCalculation();
            case "savings" ->
                futureValueCalculation();
            case "goal" ->
                savingsGoalCalculation();
        }
        return null;
    }

    /**
     * The calculates how much you have to pay to borrow money.
     *
     * @throws ArithmeticException usually thrown if division by zero or near
     * zero occurs
     */
    public void loanCalculation()
            throws ArithmeticException {

        // Divide APR by 12
        var monthlyRate = money.getRate().divide(
                new BigDecimal("12"), MathContext.DECIMAL64);
        // (1+rate)
        var temp = BigDecimal.ONE.add(monthlyRate);
        // (1+rate)^term
        temp = temp.pow(money.getTerm().intValueExact());
        // BigDecimal pow does not support negative exponents so divide 1 by the result
        temp = BigDecimal.ONE.divide(temp, MathContext.DECIMAL64);
        // 1 - (1+rate)^-term
        temp = BigDecimal.ONE.subtract(temp);
        // rate / (1 - (1+rate)^-term)
        temp = monthlyRate.divide(temp, MathContext.DECIMAL64);
        // pv * (rate / 1 - (1+rate)^-term)
        temp = money.getInputValue().multiply(temp);
        // Round to 2 decimal places using banker's rounding
        temp = temp.setScale(2, RoundingMode.HALF_EVEN);
        // Remove the sign if the result is negative
        money.setResult(temp.abs());
    }

    /**
     * The calculates how much you have saved if you deposit a regular amount
     * each time period.
     *
     * @throws ArithmeticException usually thrown if division by zero or near
     * zero occurs
     */
    public void futureValueCalculation()
            throws ArithmeticException {
        // Divide APR by 12
        var monthlyRate = money.getRate().divide(
                new BigDecimal("12"), MathContext.DECIMAL64);
        // (1+rate)
        var temp = BigDecimal.ONE.add(monthlyRate);
        // (1+rate)^term
        temp = temp.pow(money.getTerm().intValueExact());
        // 1 - (1+rate)^-term
        temp = BigDecimal.ONE.subtract(temp);
        // (1 - (1+rate)^-term) / rate
        temp = temp.divide(monthlyRate, MathContext.DECIMAL64);
        // pv * (rate / 1 - (1+rate)^-term)
        temp = money.getInputValue().multiply(temp);
        // Round to 2 decimal places using banker's rounding
        temp = temp.setScale(2, RoundingMode.HALF_EVEN);
        // Remove the sign if the result is negative
        money.setResult(temp.abs());
    }

    /**
     * The calculates how much you have to put aside each month to reach a
     * certain goal
     *
     * @throws ArithmeticException usually thrown if division by zero or near
     * zero occurs
     */
    public void savingsGoalCalculation()
            throws ArithmeticException {
        // Divide APR by 12
        var monthlyRate = money.getRate().divide(
                new BigDecimal("12"), MathContext.DECIMAL64);
        // (1+rate)
        var temp = BigDecimal.ONE.add(monthlyRate);
        // (1+rate)^term
        temp = temp.pow(money.getTerm().intValueExact());
        // 1 - ((1+rate)^term)
        temp = BigDecimal.ONE.subtract(temp);
        // rate / (1 - (1+rate)^term)
        temp = monthlyRate.divide(temp, MathContext.DECIMAL64);
        // fv * (rate / (1 - (1+rate)^term))
        temp = money.getInputValue().multiply(temp);
        temp = temp.setScale(2, RoundingMode.HALF_EVEN);
        // Remove the sign if the result is negative
        money.setResult(temp.abs());
    }

}
