package com.skypro.employee;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.DepartmentService;
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

    DepartmentService departmentService;
    List<Employee> employeeList;

    @BeforeEach
    public void serUp() {
        employeeList = new ArrayList<>();
        departmentService = new DepartmentService();
        for (Employee employees : this.employeeService.getEmployees()) {
            employeeList.add(employees);
        }

    }

    @Test
    public void employeesListNotNull() {
        Assertions.assertNotNull(employeeList);
    }

    @Test
    public void employeesOfDepartmentNotNull() {
        Assertions.assertNotNull(departmentService.employeesOfDepartment(1));
    }

    @Test
    public void employeesSalaryOfDepartmentNotNull() {
        Assertions.assertNotNull(departmentService.employeesSalaryOfDepartment(1));
    }

    @Test
    public void emoloyeesMaxSalaryOfDepartmentNotNull() {
        Assertions.assertNotNull(departmentService.emoloyeesMaxSalaryOfDepartment(1));
    }

    @Test
    public void emoloyeesMinSalaryOfDepartmentNotNull() {
        Assertions.assertNotNull(departmentService.employeesMinSalaryOfDepartment(1));
    }

    @Test
    public void employeesOfDepartmentsNotNull() {
        Assertions.assertNotNull(departmentService.employeesOfDepartmentReceiving());
    }
}
