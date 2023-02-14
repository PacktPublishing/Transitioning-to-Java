package com.kenfogel.loanbigdecimal;

import com.kenfogel.loanbigdecimal.business.Calculation;
import com.kenfogel.loanbigdecimal.data.FinancialData;
import java.math.BigDecimal;

/**
 * Calculate loan payment using BigDecimals rather than doubles
 *
 * @author Ken Fogel
 */
public class LoanBigDecimal {

    /**
     * Fill a bean a, do the calculation, and verify the result. Such
     * verification is better handled by unit testing
     */
    public void perform() {
        var data = new FinancialData(new BigDecimal("5000.0"), new BigDecimal("0.05"), new BigDecimal("60.0"));

        new Calculation().loanCalculation(data);
        
        if (data.getMonthlyPayment().equals(new BigDecimal("94.36"))) {
            System.out.printf("Test passed%n");
        } else {
            System.out.printf("Test failed: %.2f %s%n", data.getMonthlyPayment(), "94.36");
        }
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new LoanBigDecimal().perform();
    }
}
