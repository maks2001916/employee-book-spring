package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    private final EmployeeService employeeService = new EmployeeService();
    public List<Employee> employeesOfDepartment(Integer department) {
        List<Employee> allEmployees = new ArrayList<>();
        for (Employee employee : this.employeeService.getEmployees()) {
            if (department == employee.getDapartament()) {
                allEmployees.add(employee);
            }
        }
        return allEmployees;
    }

    public Integer employeesSalaryOfDepartment(Integer department) {
        Integer sumSalary = 0;
        for (Employee employee : this.employeeService.getEmployees()) {
            if (department == employee.getDapartament()) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        return sumSalary;
    }

    public Integer emoloyeesMaxSalaryOfDepartment(Integer depertment) {
        Integer maxSalary = 0;
        for (Employee employee : this.employeeService.getEmployees()) {
            if (depertment == employee.getDapartament()) {
                if (employee.getSalary() > maxSalary) {
                    maxSalary = employee.getSalary();
                }
            }
        }
        return maxSalary;
    }

    public Integer employeesMinSalaryOfDepartment(Integer dapartment) {
        Integer minSalary = 10000;
        for (Employee employee : this.employeeService.getEmployees()) {
            if (dapartment == employee.getDapartament())
                if (employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                }
        }
        return minSalary;
    }

    public Map<Integer, List<Employee>> employeesOfDepartment() {
        Map<Integer, List<Employee>> listEmployees = new HashMap<>();
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : this.employeeService.getEmployees()) {
            employees.add(employee);
            listEmployees.put(employee.getDapartament(), employees);
        }
        return listEmployees;
    }

}
