package com.skypro.employee;

import com.skypro.employee.controller.EmployeeController;
import com.skypro.employee.model.Employee;
import com.skypro.employee.service.EmployeeService;
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

    @Test
    public void addEmployee() {
        Employee employee1 = new Employee("name1", "lastName1",1, 12345);
        Employee employee2 = new Employee("name2", "lastName2",2, 17392);
        Employee employee3 = new Employee("name3", "lastName3", 2, 18976);

        Map<Integer,Employee> employeeMap = new HashMap<>();

        employeeMap.put(employee1.getId(), employee1);
        employeeMap.put(employee2.getId(), employee2);
        employeeMap.put(employee3.getId(), employee3);

        employeeMap.put(employee1.getId(), employee1);
        employeeMap.put(employee2.getId(), employee2);
        employeeMap.put(employee3.getId(), employee3);


    }

    @Test
    public void getAllEmployeesNotNull() {

    }

}
