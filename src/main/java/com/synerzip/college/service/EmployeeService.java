package com.synerzip.college.service;

import com.synerzip.college.controller.CollegeController;
import com.synerzip.college.model.Department;
import com.synerzip.college.model.Employee;
import com.synerzip.college.repository.DepartmentRepository;
import com.synerzip.college.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(CollegeController.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public Employee getEmployee(Integer id) {
        Employee employee = null;
        try {
            employee = employeeRepository.getOne(id);
        } catch (Exception e) {
            log.error("employee not found with id : "+id);
        }
        return employee;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public List<Employee> getAllEmployeeFromDepartment(Integer depId) {
        return employeeRepository.getAllEmployeeFromDepartment(depId);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        try {
            Employee dbEmployee = employeeRepository.getOne(id);
            if(null != dbEmployee) {
                if (!StringUtils.isEmpty(employee.getName())) {
                    dbEmployee.setName(employee.getName());
                }
                if(!StringUtils.isEmpty(employee.getAddress())) {
                    dbEmployee.setAddress(employee.getAddress());
                }
            }
            return employeeRepository.save(dbEmployee);
        } catch (Exception e) {
            log.error("department not found with id : "+id);
            throw new EntityNotFoundException("can't update department, because department not exist with id : "+id);
        }
    }

    public String deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return "employee deleted";
    }

    public Employee addEmployeeToDepartment(Integer id, Employee employee) {
        Department department = departmentRepository.getOne(id);
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }
}
