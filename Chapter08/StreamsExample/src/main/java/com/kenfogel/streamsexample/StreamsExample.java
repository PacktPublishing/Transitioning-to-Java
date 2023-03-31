package com.kenfogel.streamsexample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class demonstrates the use of streams when processing a collection
 *
 * @author Ken Fogel
 */
public class StreamsExample {

    private final List<Employee> staffList;

    /**
     * This contructor is creating a List of Employee objects
     */
    public StreamsExample() {
        staffList = Arrays.asList(new Employee("A9", "Benson", "Bill", "Sales", 56000),
                new Employee("A1", "Clarkson", "Bill", "Sales", 56000),
                new Employee("A2", "Blunt", "Wesley", "HR", 56000),
                new Employee("A4", "Smith", "John", "Accounting", 56000),
                new Employee("A3", "Smith", "Joan", "Software", 56000),
                new Employee("A5", "Lance", "Gilbert", "Sales", 56000));
    }

    /**
     * Here we are performing two actions on ther List. The first creates a new
     * list of employees whose first name starts with the letter J. The second
     * creates a new list sorted by last name.
     */
    public void perform() {
        // Here we employ the stream method on the list to return a new list
        List<Employee> filteredList = staffList.stream().filter(s -> s.firstName().startsWith("J")).collect(Collectors.toList());
        System.out.printf("%s%n%n", filteredList);

        // Here we use a stream to display a sorted list    
        staffList.stream().sorted((e1, e2) -> e1.lastName().compareTo(e2.lastName())).forEach(System.out::println);
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new StreamsExample().perform();
    }
}
