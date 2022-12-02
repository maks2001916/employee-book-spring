package com.skypro.employee;

import com.skypro.employee.controller.EmployeeController;
import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
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
    EmployeeRequest employee1 = new EmployeeRequest();
    EmployeeRequest employee2 = new EmployeeRequest();

    @BeforeEach
    public void addEmployee() {
        employee1.setLastName("Name1");
        employee1.setFirstName("firstName1");
        employee1.setDepartament(1);
        employee1.setSalary(1234);
        employee1.setId(1);

        employee2.setLastName("name2");
        employee2.setFirstName("firstName2");
        employee2.setDepartament(2);
        employee2.setSalary(12345);
        employee2.setId(2);

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);

    }

    @Test
    public void addEmployeeNullException() {
        Assertions.assertThrows(IllegalArgumentException.class, this::addEmployee);
    }


    @Test
    public void geleteNotEmployee() {
        Assertions.assertEquals(employee1, employeeService.getEmployee(employee1.getId()));
        Assertions.assertEquals(employee2, employeeService.getEmployee(employee2.getId()));
    }

    @Test
    public void getAllEmployeesNotNull() {
        Assertions.assertNotNull(employeeService);
    }



}
