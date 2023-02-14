package com.kenfogel.calculationtest;

import com.kenfogel.loanbigdecimalunittest.business.Calculation;
import com.kenfogel.loanbigdecimalunittest.data.FinancialData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

/**
 * This class runs multiple tests using a single test method but with different
 * values for each test. 
 * 
 * The results are shown in the console and written to a
 * file you can find in LoanBigDecimalUnitTest/target/surefire-reports
 *
 * @author Ken Fogel
 */
public class ParameterizedTests {

    private Calculation calc;
    private FinancialData data;

    /**
     * Before each run of a test this method is called to create a new instance
     * of the Calculation object
     */
    @BeforeEach
    public void init() {
        calc = new Calculation();
    }

    /**
     * The list of values to use in testing organized in CSV format and the
     * method to use for each test
     *
     * @param args
     */
    @ParameterizedTest
    @CsvSource({
        "5000, 0.05, 60, 94.36",
        "3000, 0.05, 24, 131.61",
        "20000, 0.05, 72, 322.10"
    })
    public void knownValueLoanCalculationTest_param(ArgumentsAccessor args) {
        data = buildBean(args);
        calc.loanCalculation(data);
        assertEquals(new BigDecimal(args.getString(3)), data.getMonthlyPayment());
    }

    /**
     * The first three values in each row is the input and the last value is the
     * expected result
     *
     * @param args
     * @return
     */
    private FinancialData buildBean(ArgumentsAccessor args) {
        return new FinancialData(new BigDecimal(args.getString(0)),
                new BigDecimal(args.getString(1)),
                new BigDecimal(args.getString(2)));

    }
}
