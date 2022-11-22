package com.skypro.employee.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

public class Employee {
    private static int counter;
    private int id;
    private String firstName;
    private String lastName;
    private int dapartament;
    private int salary;

    public Employee(String firstName, String lastName, int dapartament, int salary) {
        if (StringUtils.isEmpty(firstName)) {
            firstName = StringUtils.capitalize(firstName);
            this.firstName = firstName;
        } else {
            badRequest();
        }
        if (StringUtils.isEmpty(lastName)) {
            lastName = StringUtils.capitalize(lastName);
            this.lastName = lastName;
        } else {
            badRequest();
        }

        this.dapartament = dapartament;
        this.salary = salary;

        this.id = counter++;
    }

    public ResponseEntity.BodyBuilder badRequest() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST);
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDapartament() {
        return dapartament;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dapartament=" + dapartament +
                ", salary=" + salary +
                '}';
    }
}
