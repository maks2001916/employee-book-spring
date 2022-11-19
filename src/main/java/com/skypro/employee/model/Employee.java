package com.skypro.employee.model;

public class Employee {
    private static int counter;
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int dapartament;
    private final int salary;

    public Employee(String firstName, String lastName, int dapartament, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dapartament = dapartament;
        this.salary = salary;

        this.id = counter++;
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
