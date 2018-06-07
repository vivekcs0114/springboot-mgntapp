package com.synerzip.college.controller;

import com.synerzip.college.model.Employee;
import com.synerzip.college.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/departments/{id}")
    public  List<Employee> getAllEmployeeFromDepartment(@PathVariable("id") Integer id) {
        return employeeService.getAllEmployeeFromDepartment(id);
    }

    @PostMapping("/departments/{id}")
    public  Employee addEmployeeToDepartment(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return employeeService.addEmployeeToDepartment(id, employee);
    }
}
