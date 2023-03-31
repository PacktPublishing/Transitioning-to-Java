package com.kenfogel.bankswing.business;

import com.kenfogel.bankswing.data.FinanceBean;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is the class that contains the three calculations. It is unchanged in
 * Swing, JavaFX, and Server-Side
 *
 * @author Ken Fogel
 */
public class FinanceCalculations {

    private static final Logger LOG
            = LogManager.getLogger(FinanceCalculations.class);

    /**
     * The calculates how much you have to pay to borrow money.
     *
     * @param money the bean that holds the data, it may be a regular Java Bean
     * or a JavaFX bean
     * @throws ArithmeticException usually thrown if division by zero or near
     * zero occurs
     */
    public void loanCalculation(FinanceBean money) throws ArithmeticException {

        // Divide APR by 12
        var monthlyRate = money.getRate().divide(
                new BigDecimal("12"), MathContext.DECIMAL64);
        // At each step this variable is updated
        // (1+rate)
        var temp = BigDecimal.ONE.add(monthlyRate);
        // (1+rate)^term
        temp = temp.pow(money.getTerm().intValueExact());
        // BigDecimal pow does not support negative exponents 
        // so divide 1 by the result
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
     * @param money the bean that holds the data, it may be a regulat Java Bean
     * or a JavaFX bean
     * @throws ArithmeticException usually thrown if division by zero or near
     * zero occurs
     */
    public void futureValueCalculation(FinanceBean money)
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
     * @param money the bean that holds the data, it may be a regulat Java Bean
     * or a JavaFX bean
     * @throws ArithmeticException usually thrown if division by zero or near
     * zero occurs
     */
    public void savingsGoalCalculation(FinanceBean money)
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
