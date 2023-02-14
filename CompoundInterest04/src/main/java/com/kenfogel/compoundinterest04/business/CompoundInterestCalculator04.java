// The folder that contains this class
package com.kenfogel.compoundinterest04.business;

// This program will be using the NumberFormat class. 
// This class is part of Java's standard library because 
// the first name in its package is 'java'.
import java.text.NumberFormat;

 // The first line shows us that:
 // 1) This class is public and so can be instantiated in any other 
 // class that declares a reference to it.
 // 2) The class name,CompoundInterestCalculator04, must also be the name 
 // of the file. You can have more than one class structure in a file but 
 // only one of them may be public. 
/**
 * The business class
 * 
 * @author omniprof (This is the developer's name
 */
public class CompoundInterestCalculator04 {
    
    // Here we are declaring four instance variables of type double. The 
    // access control designation of 'private' means that these variables 
    // cannot be accessed by any other class that may have a reference to 
    // this class. The modifier 'final' defines these variable as immutable.
    // In a class access control does not apply but modifiers do. These 
    // variables must be initialized when they are declared, as they are here, 
    // or in the class constructor. 
    private final double principal = 100.0;
    private final double annualInterestRate = 0.05;
    private final double compoundPerTimeUnit = 12.0;
    private final double time = 5.0; // 

    // Here we are declaring two instances of a NumberFormat class. You can
    // see from thr variable names that each is planned for a different 
    // format. These are final meaning they must be initialized. The values 
    // were initialized where they were declared. Whe these two could have 
    // been instantiated where they were declared, I have chosen to 
    // instantiate them in the constructor just to demonstrate how it is 
    // done. These two references will be instantiated in the constructor.
    private final NumberFormat currencyFormat;
    private final NumberFormat percentFormat;

    // Here is the constructor. It is easy top recognize as it must have the 
    // same name as the class. It does not return a value as the constructor 
    // is invoked as part of the 'new' operation and therefore ther is nothing
    // to assign a result from a return statement to.
    // This is a default constructor and we know this because there are no 
    // arguments inside the parenthesis. A class may have only one default
    // constructor.

    // The task that this constructor is carrying out is the initialization
    // and configuration of the NumberFormat objects. Rather than use the 
    // 'new' operator, this class is instantiated by means of a factory method.
    // In this method there will be a 'new' but additional tasks must be 
    // completed first. Also take note that the methods are called thru the 
    // class name and not through an object name, very much like the Math 
    // library methods. This tells us that getCurrencyInstance and 
    // getPercentInstance are static methods. We will discuss static lather 
    // in this chapter.
    
    /**
     * Default Constructor
     *
     * @author Ken Fogel
     */
    public CompoundInterestCalculator04() {
        currencyFormat = NumberFormat.getCurrencyInstance();
        percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(0);
        percentFormat.setMaximumFractionDigits(5);
    }

     // This is the method that is called after the object is instantiated. 
     // The name perform is just a name of my choosing. All that is important 
     // to remember is that, with the exception of the constructor, all 
     // methods should be verbs. Remember that class and variables should 
     // be nouns.
    /**
     * The first method called in the application
     */
    public void perform() {
        // Determine the final result and assign the result in the variable result. 
        var result = calculateCompoundInterest();
        
        // Display the result formatted appropriately
        System.out.printf("If you deposit %s in a savings account "
                + "that pays %s annual interest compounded monthly%n"
                + "you will have after %1.0f years %s%n", 
                currencyFormat.format(principal),
                percentFormat.format(annualInterestRate),
                time, currencyFormat.format(result));
    }

     // Using the instance variables calculate the result to a variable 
     // named 'result' that the method returns to whomever called it. It is 
     // a private method so only methods in this class can see it.
    /**
     * @return result The answer to the calculation
     */
    private double calculateCompoundInterest() {
        var result = principal * Math.pow(1 + annualInterestRate / 
                compoundPerTimeUnit, time * compoundPerTimeUnit);
        return result;
    }
}

