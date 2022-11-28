package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department/{id}/employees")
    public List<Employee> getAllEmployeesDepartment(@PathParam("id") Integer a) {
        return this.departmentService.employeesOfDepartment(a);
    }

    @GetMapping("/department/{id}/salary/sum")
    public Integer getSumSalaryEmployeesDepartment(@PathParam("id") Integer a) {
        return this.departmentService.employeesSalaryOfDepartment(a);
    }

    @GetMapping("/department/{id}/salary/max")
    public Integer getMaxSalaryEmployeesDepartment(@PathParam("id") Integer a) {
        return this.departmentService.emoloyeesMaxSalaryOfDepartment(a);
    }

    @GetMapping("/department/{id}/salary/min")
    public Integer getMinSalaryEmployeesDepartment(@PathParam("id") Integer a) {
        return this.departmentService.employeesMinSalaryOfDepartment(a);
    }

    @GetMapping("/department/employees/grouped")
    public Map<Integer, List<Employee>> getEmployeesDepartment() {
        return this.departmentService.employeesOfDepartment();
    }

}
