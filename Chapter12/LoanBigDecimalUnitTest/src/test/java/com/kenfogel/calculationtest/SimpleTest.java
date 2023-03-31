package com.kenfogel.calculationtest;

import com.kenfogel.loanbigdecimalunittest.business.Calculation;
import com.kenfogel.loanbigdecimalunittest.data.FinancialData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import java.math.BigDecimal;

/**
 * This class uses single methods for each test.
 *
 * The results are shown in the console and written to a file you can find in
 * LoanBigDecimalUnitTest/target/surefire-reports
 *
 * @author omniprof
 */
public class SimpleTest {

    private Calculation calc;
    private FinancialData data;

    @BeforeEach
    public void init() {
        calc = new Calculation();
        data = new FinancialData();
    }

    /**
     * Test to determine if the correct answer is return by loanCalculation
     */
    @Test
    public void knownValueLoanCalculationTest() {
        data.setAmountBorrowed(new BigDecimal("5000"));
        data.setAnnualRate(new BigDecimal("0.05"));
        data.setTerm(new BigDecimal("60"));
        calc.loanCalculation(data);
        assertEquals(new BigDecimal("94.36"), data.getMonthlyPayment());
    }

    /**
     * Test to determine if the exected exception is thrown if we try to divide
     * bt zero
     */
    @Test
    public void knownValueLoanExceptionTest() {
        data.setAmountBorrowed(new BigDecimal("5000"));
        data.setAnnualRate(new BigDecimal("0.05"));
        data.setTerm(new BigDecimal("0"));
        ArithmeticException ex = assertThrowsExactly(ArithmeticException.class, () -> {
            calc.loanCalculation(data);
        });
        assertEquals("Division by zero", ex.getMessage());
    }
}
