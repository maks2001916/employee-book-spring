package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmploees() {
        return this.employees.values();
    }

    public Map<Integer, Employee> addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Empliyee name should be set");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartament(),
                employeeRequest.getSalary());
        this.employees.put(employee.getId(), employee);
        return employees;
    }

    public int getSalarySum() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public int getSalaryWolume() {
        return employees.size();
    }

    public int getAverageValue() {
        return employees.values().stream().mapToInt(Employee::getSalary).sum() / getSalaryWolume();
    }

    public int getSalaryMin() {
        return employees
                .values()
                .stream()
                .mapToInt(Employee::getSalary)
                .min()
                .orElseThrow(( ) -> new RuntimeException("Something went wrong"));
    }

    public int getSalaryMax() {
        return employees
                .values()
                .stream()
                .mapToInt(Employee::getSalary)
                .max()
                .orElseThrow(() -> new RuntimeException("Something went wrong"));
    }

    public int getHighSalary() {
        System.out.println();
        return employees
                .values()
                .stream()
                .mapToInt(Employee::getSalary)
                .filter(e -> e > getAverageValue()).sum();

    }
}
