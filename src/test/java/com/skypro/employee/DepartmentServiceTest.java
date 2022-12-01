package com.skypro.employee;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    List<Employee> employeeList;

    @BeforeEach
    public void serUp() {
        employeeList = new ArrayList<>();
    }

    @Test
    public void employeesListNotNull() {
        for (Employee employees : this.employeeService.getEmployees()) {
            employeeList.add(employees);
        }
        Assertions.assertNotNull(employeeList);
    }
}
