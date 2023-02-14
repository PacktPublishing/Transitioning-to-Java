package com.kenfogel.iteration;

import java.util.Random;

/**
 * Examples of for, while and do-while loops
 *
 * @author Ken Fogel
 */
public class Iteration {

    public void perform() {
        doForTest();
        doWhileTest();
        doDoWhileTest();
    }

    public void doForTest() {
        for (int x = 0; x < 10; ++x) {
            System.out.printf("ForTest - Value of x is %d%n", x);
        }
    }

    public void doWhileTest() {

        var rand = new Random();
        int x = rand.nextInt(12);
        while (x < 10) {
            x = rand.nextInt(12);
            System.out.printf("WhileTest - Value of x is %d%n", x);
        }
        System.out.printf("Value of x not less than 10%n");
    }

    public void doDoWhileTest() {

        var rand = new Random();
        int x;
        do {
            x = rand.nextInt(12);
            System.out.printf("DoWhileTest - Value of x is %d%n", x);
        } while (x < 10);
        System.out.printf("Value of x not less than 10%n");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Iteration().perform();
    }

}
