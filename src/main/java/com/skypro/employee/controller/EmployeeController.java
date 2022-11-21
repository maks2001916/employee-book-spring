package com.skypro.employee.controller;

import com.skypro.employee.exception.EmployeeNotFoundException;
import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployes() {
        return this.employeeService.getAllEmploees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return (Employee) this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employees/salary/sum")
    public int getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @GetMapping("/employees/salaty/max")
    public Employee getSalaryMax() throws EmployeeNotFoundException {
        return this.employeeService.getSalaryMax();
    }

    @GetMapping("/employees/salary/min")
    public Employee getSalaryMin() throws EmployeeNotFoundException {
        return this.employeeService.getSalaryMin();
    }

    @GetMapping("/employees/high-salary")
    public int getHighSalary() {
        return this.employeeService.getHighSalary();
    }
}
