package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    public int getAllEmploees() {
        return this.employees.size();
    }
    public Employee addEmployee(Employee employee) {
        if (employee.getFirstName() == null || employee.getLastName() == null) {
            throw new IllegalArgumentException("Empliyee name should be set");
        }
        this.employees.add(employee);
        return employee;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public Employee getEmployee(int department) {
        return employees.get(department);
    }

    public int getSalarySum() {
        return employees
                .stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public int getSalaryWolume() {
        return employees.size();
    }

    public int getAverageValue() {
        return employees.stream().mapToInt(Employee::getSalary).sum() / getSalaryWolume();
    }

    public int getSalaryMin() {
        return employees
                .stream()
                .mapToInt(Employee::getSalary)
                .min()
                .orElseThrow(( ) -> new RuntimeException("Something went wrong"));
    }

    public int getSalaryMax() {
        return employees
                .stream()
                .mapToInt(Employee::getSalary)
                .max()
                .orElseThrow(() -> new RuntimeException("Something went wrong"));
    }

    public int getHighSalary() {
        System.out.println();
        return employees
                .stream()
                .mapToInt(Employee::getSalary)
                .filter(e -> e > getAverageValue()).sum();

    }
}
