package com.skypro.employee.service;

import com.skypro.employee.exception.EmployeeNotFoundException;
import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmploees() {
        return this.employees.values();
    }

    public Map<Integer, Employee> addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Employee name should be set");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartament(),
                employeeRequest.getSalary());
        this.employees.put(employee.getId(), employee);
        return employees;
    }

    public int getSalarySum() {
        return employees
                .values()
                .stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public int getSalaryWolume() {
        return employees.size();
    }

    public int getAverageValue() {
        return employees.values().stream().mapToInt(Employee::getSalary).sum() / getSalaryWolume();
    }

    public Employee getSalaryMin() throws EmployeeNotFoundException {
        return employees
                .values()
                .stream()
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(( ) -> new EmployeeNotFoundException("Something went wrong"));
    }

    public Employee getSalaryMax() throws EmployeeNotFoundException {
        return employees
                .values()
                .stream()
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Something went wrong"));
    }

    public int getHighSalary() {
        int avg = getAverageValue();
        return employees
                .values()
                .stream()
                .filter(e -> e.getSalary() > avg)
                .mapToInt(e -> e.getSalary());
    }
}
