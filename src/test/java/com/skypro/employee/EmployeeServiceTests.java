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
    EmployeeRequest employee3 = new EmployeeRequest();

    @BeforeEach
    public void addEmployee() {
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        employeeService.addEmployee(employee3);
    }

    @Test
    public void geleteNotEmployee() {

        Assertions.assertEquals(employee1, employeeService.getEmployee(employee1.getId()));
        Assertions.assertEquals(employee2, employeeService.getEmployee(employee2.getId()));
        Assertions.assertEquals(employee3, employeeService.getEmployee(employee3.getId()));

    }

    @Test
    public void getAllEmployeesNotNull() {
        Assertions.assertNotNull(employeeService);
    }

}
