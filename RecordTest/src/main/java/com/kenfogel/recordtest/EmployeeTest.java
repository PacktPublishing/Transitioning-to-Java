package com.kenfogel.recordtest;

/**
 * A simple example of using a Record.
 *
 * @author Ken Fogel
 */
public class EmployeeTest {

    public void perform() {
        var emp = new Employee("Ken", 12000.00);

        /*
         * Unlike a JavaBean with its getters and setters, a record's members
         * are accessed using the identifier for the variable.
         */
        System.out.printf("%s %.2f%n", emp.name(), emp.salary());
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new EmployeeTest().perform();
    }

}
