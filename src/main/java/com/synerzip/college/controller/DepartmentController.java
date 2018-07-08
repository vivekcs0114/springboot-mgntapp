package com.synerzip.college.controller;

import com.synerzip.college.model.Department;
import com.synerzip.college.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        System.out.println(departmentService.loadProperty());
        return departmentService.getDepartment(id);
    }

    @GetMapping
    public List<Department> getAllDepartment(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int limit) {
        return departmentService.getAllDepartment(page, limit);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Integer id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable("id") Integer id) {
        return departmentService.deleteDepartment(id);
    }
}
