package com.kenfogel.compoundinterest05.ui;

import com.kenfogel.compoundinterest05.business.CompoundInterestCalculator05;
import com.kenfogel.compoundinterest05.data.CompoundInterestData05;
import java.text.NumberFormat;
import java.util.Scanner;

public class CompoundInterestUI05 {

    private CompoundInterestData05 inputData;
    private final CompoundInterestCalculator05 calculator;
    private final Scanner sc;
    
    private final NumberFormat currencyFormat;
    private final NumberFormat percentFormat;


    public CompoundInterestUI05() {
        currencyFormat = NumberFormat.getCurrencyInstance();
        percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(0);
        percentFormat.setMaximumFractionDigits(5);
        
        sc = new Scanner(System.in);
        calculator = new CompoundInterestCalculator05();
    }

//    public void doUserInterface() {
//        doUserInstructions();
//        var principal = doPrincipalInput();
//        var annualInterestRate = doAnnualInterestRate();
//        var compoundPerTimeUnit = doCompoundPerTimeUnit();
//        var time = doTimeInput();
//        inputData = new CompoundInterestData05(principal, annualInterestRate, compoundPerTimeUnit, time);
//        calculator.calculateCompoundInterest(inputData);
//        displayTheResults();
//    }
    
     public void doUserInterface() {
        doUserInstructions();
        var principal = 
            doUserInput("Enter the principal: ");
        var annualInterestRate = 
            doUserInput("Enter the interest rate: ");
        var compoundPerTimeUnit = 
            doUserInput("Enter periods per year: ");
        var time = doUserInput("Enter the years: ");
        inputData = new CompoundInterestData05(
              principal, 
              annualInterestRate, 
              compoundPerTimeUnit, 
              time);
        calculator.calculateCompoundInterest(inputData);
        displayTheResults();
    }
    

    private void displayTheResults() {
        // Display the result formatted appropriately
        System.out.printf("If you deposit %s in a savings account "
                + "that pays %s annual interest compounded monthly%n"
                + "you will have after %1.0f years %s%n", 
                currencyFormat.format(inputData.getPrincipal()),
                percentFormat.format(inputData.getAnnualInterestRate()),
                inputData.getTime(), 
                currencyFormat.format(inputData.getResult()));
    }

    private void doUserInstructions() {
        System.out.printf("Welcome to the Compound Interest Calculator%n%n");
    }
    
    private double doUserInput(String prompt) {
        System.out.printf(prompt);
        var value = sc.nextDouble();
        return value;
    }
//    private double doPrincipalInput() {
//        System.out.printf("Enter the principal amount: ");
//        var value = sc.nextDouble();
//        return value;
//    }
//    private double doAnnualInterestRate() {
//        System.out.printf("Enter the interest rate: ");
//        var value = sc.nextDouble();
//        return value;
//    }
//    private double doCompoundPerTimeUnit() {
//        System.out.printf("Please periods per year: ");
//        var value = sc.nextDouble();
//        return value;
//    }
//    private double doTimeInput() {
//        System.out.printf("Enter the years: ");
//        var value = sc.nextDouble();
//        return value;
//    }
}
