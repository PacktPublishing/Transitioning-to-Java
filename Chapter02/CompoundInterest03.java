#!//home/omniprof/jdk-17.0.3+7/bin/java --source 17
import java.text.NumberFormat;

/**
 * This version of the program will only run using the shebang feature in Linux.
 * Running it from the command line as 'java CompoundInterest03.java' will fail
 * because the first line is only recognized on a Linux system. On a Linux
 * system you must make this file executable and then it can be run from the
 * command line with '.\CompoundInterest03'.
 *
 * This class will calculate the future value of a fixed amount of money over
 * time. It is divided into two classes. There may only be one public class in a
 * file.
 *
 * @author Ken Fogel
 */
public class CompoundInterest03 {

    public static void main(String[] args) {
        var banker = new CompoundInterestCalculator03();
        banker.perform();
    }
}

/**
 * The seocnd class that carries out the calculation.
 *
 * @author Ken Fogel
 */
class CompoundInterestCalculator03 {

    private final double principal = 100.0;
    private final double annualInterestRate = 0.05;
    private final double compoundPerTimeUnit = 12.0;
    private final double time = 5.0; // 

    private final NumberFormat currencyFormat;
    private final NumberFormat percentFormat;

    public CompoundInterestCalculator03() {
        currencyFormat = NumberFormat.getCurrencyInstance();
        percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(0);
        percentFormat.setMaximumFractionDigits(5);
    }

    public void perform() {
        var result = calculateCompoundInterest();
        System.out.printf("If you deposit %s in a savings account "
                + "that pays %s annual interest compounded monthly%n"
                + "you will have after %1.0f years %s%n",
                currencyFormat.format(principal),
                percentFormat.format(annualInterestRate),
                time, currencyFormat.format(result));
    }

    private double calculateCompoundInterest() {
        var result = principal * Math.pow(1 + annualInterestRate
                / compoundPerTimeUnit, time * compoundPerTimeUnit);
        return result;
    }
}
