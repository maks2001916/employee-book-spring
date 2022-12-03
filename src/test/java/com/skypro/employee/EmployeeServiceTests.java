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

    public final EmployeeService employeeService = new EmployeeService();
    Employee employee1 = new Employee("name1", "lastName1", 1, 124354);
    Employee employee2 = new Employee("name2", "lastName2", 2, 123615);

    @BeforeEach
    public void addEmployee() {

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);

    }

    @Test
    public void addEmployeeNullException() {
        Assertions.assertThrows(IllegalArgumentException.class, this::addEmployee);
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
