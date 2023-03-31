package com.kenfogel.loanbigdecimal.business;

import com.kenfogel.loanbigdecimal.data.FinancialData;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * The loan calculation using BigDecimals
 *
 * @author omniprof
 */
public class Calculation {

    public void loanCalculation(FinancialData data) throws ArithmeticException {

        var monthlyRate = data.getAnnualRate().divide(new BigDecimal("12"), MathContext.DECIMAL64);
        // (1+rate)
        var temp = BigDecimal.ONE.add(monthlyRate);
        // (1+rate)^term
        temp = temp.pow(data.getTerm().intValueExact());
        // BigDecimal pow does not support negative exponents so divide 1 by the result
        temp = BigDecimal.ONE.divide(temp, MathContext.DECIMAL64);
        // 1 - (1+rate)^-term
        temp = BigDecimal.ONE.subtract(temp);
        // rate / (1 - (1+rate)^-term)
        temp = monthlyRate.divide(temp, MathContext.DECIMAL64);
        // pv * (rate / 1 - (1+rate)^-term)
        temp = data.getAmountBorrowed().multiply(temp);
        temp = temp.setScale(2, RoundingMode.HALF_EVEN);
        data.setMonthlyPayment(temp.abs());
    }
}
