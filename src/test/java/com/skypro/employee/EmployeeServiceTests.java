package com.skypro.employee;

import com.skypro.employee.controller.EmployeeController;
import com.skypro.employee.model.Employee;
import com.skypro.employee.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootTest
public class EmployeeServiceTests {

    public EmployeeService employeeService;
    Employee employee1 = new Employee("name1", "lastName1", 1, 124354);
    Employee employee2 = new Employee("name2", "lastName2", 2, 123615);
    int maxSalary = 0;
    int minSalary = 0;
    int highSalary = 0;
    @BeforeEach
    public void addEmployee() {
        this.employeeService = new EmployeeService();
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        maxSalary = employeeService.getSalaryMax();
        minSalary = employeeService.getSalaryMin();
        highSalary = employeeService.getHighSalary();
    }

    @Test
    public void addingTheRightEmployee() {
        Employee expected = new Employee("firstName3", "lastName3", 3, 1241);
        Employee actual = this.employeeService.addEmployee(expected);
    }

    @Test
    public void getAListOfAllTheWorkers() {
        EmployeeService current = new EmployeeService();
        current.addEmployee(employee1);
        current.addEmployee(employee2);
        Assertions.assertEquals(employeeService, current);
    }

    @Test
    public void getEmployeesWithTheMaxSalary() {
        Assertions.assertEquals(employeeService.getSalaryMax(), maxSalary);
    }

    @Test
    public void getEmployeesWithTheMinSalary() {
        Assertions.assertEquals(employeeService.getSalaryMin(), minSalary);
    }

    @Test
    public void getEmployeesWithTheHighSalary() {
        Assertions.assertEquals(employeeService.getHighSalary(), highSalary);
    }

    @Test
    public void addEmployeeNullException() {
        Employee employee3 = new Employee("name3", "lastName3", 3, 2431);
        employeeService.addEmployee(employee3);
        Assertions.assertThrows();
    }


    @Test
    public void deleteNotEmployee() {
        Assertions.assertEquals(employee1, employeeService.getEmployee(employee1.getDapartament()));
        Assertions.assertEquals(employee2, employeeService.getEmployee(employee2.getDapartament()));
    }

    @Test
    public void getAllEmployeesNotNull() {

        Assertions.assertNotNull(employeeService);
    }



}
