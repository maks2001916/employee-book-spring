package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();
    private List<Employee> employeeList = new ArrayList<>();
    public Collection<Employee> getAllEmploees() {
        return this.employees.values();
    }
    private int counter = 0;
    public Map<Integer, Employee> addEmployee(Employee employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Empliyee name should be set");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDapartament(),
                employeeRequest.getSalary());
        this.employees.put(counter, employee);
        employeeList.add(employee);
        counter++;
        return employees;
    }

    public List<Employee> getEmployees() {
        return employeeList;
    }

    public Employee getEmployee(int department) {
        return employees.get(department);
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
