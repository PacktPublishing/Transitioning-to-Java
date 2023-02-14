package com.kenfogel.fileexception;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class demonstrates checked, unchecked, and custom exceptions. It also
 * shows how the finally part of a try/catch block works.
 *
 * @author Ken Fogel
 */
public class FileException {

    /**
     * A checked exception must be called from within a try/catch block as this
     * example does or have a throws clause such that this method call must be
     * in a try/catch
     */
    public void doCheckedException() {
        List<String> fileContents = null;

        /*
         * Create a file called textfile.txt with a few lines of text and place
         * it in a path appropriate for your OS. Execute this method and you
         * should see the lines of text. Now change the name of this file to one
         * that does not exist and you will see the exception occuring.
         */
        Path path2 = Paths.get("c:/temp/textfile.txt");

        try {
            fileContents = Files.readAllLines(path2);
        } catch (NoSuchFileException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.printf("%s%n", fileContents);
    }

    /**
     * In this method we are purposely dividing by zero to force a
     * java.lang.ArithmeticException: / by zero error
     */
    public void doUncheckedException() {
        int dividend = 8;
        int divisor = 0;
        int result = dividend / divisor;
        System.out.printf("%d%n", result);
    }

    /**
     * This method is called by makeCustomException. If passed a value less than
     * zero then the custom exception class is thrown. This requires a throws
     * clause as we do not intend to deal with the exception in this method.
     *
     * @param value
     * @throws NegativeNumberException
     */
    private void doCustomException(int value) throws NegativeNumberException {
        if (value < 0) {
            throw new NegativeNumberException();
        }
        System.out.printf("value = %d%n", value);
    }

    /**
     * This method is calling doCustomException with a value that will result in
     * an exception. It is caught in this class as the method it calls is
     * throwing the exception.
     */
    public void makeCustomException() {
        try {
            doCustomException(-1);
        } catch (NegativeNumberException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * The try/catch block has a finally section. Regardless of whether or not
     * an exception is thrown, the code in the finally block is always executed.
     *
     * @param dividend
     * @param divisor
     */
    public void doFinallyExample(int dividend, int divisor) {
        int result = 0;
        try {
            result = dividend / divisor;
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        } finally {
            System.out.printf(
                    "Finally block is always executed%n");
        }
    }

    /**
     * Each of these methods can throw an exception. It is easier to follow if
     * you run each method individually.
     */
    public void perform() {
        doCheckedException();
        // doUncheckedException();
        // makeCustomException();
        // doFinallyExample(4, 0);
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new FileException().perform();
    }
}
