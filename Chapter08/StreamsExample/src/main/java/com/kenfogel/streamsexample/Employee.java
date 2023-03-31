package com.kenfogel.streamsexample;

/**
 * Record class with 2 members
 */
public record Employee(String employeeId, String lastName, 
        String firstName, String department, double salary) { }

