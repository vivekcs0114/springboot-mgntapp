package com.synerzip.college.service;

import com.synerzip.college.controller.CollegeController;
import com.synerzip.college.model.Department;
import com.synerzip.college.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DepartmentService {

    private static final Logger log = LoggerFactory.getLogger(CollegeController.class);

    @Autowired
    DepartmentRepository departmentRepository;

    public Department getDepartment(Integer id) {
        Department department = null;
        try {
            department = departmentRepository.getOne(id);
        } catch (Exception e) {
            log.error("department not found with id : "+id);
            throw new EntityNotFoundException("department not found with id : "+id);
        }
        return department;
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Integer id, Department department) {
        Department dbDepartment = null;
        try {
            dbDepartment = departmentRepository.getOne(id);
            if(null != dbDepartment) {
                return departmentRepository.save(department);
            }
            return dbDepartment;
        } catch (Exception e) {
            log.error("department not found with id : "+id);
            throw new EntityNotFoundException("can't update department, because department not exist with id : "+id);
        }
    }

    public String deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
        return "department deleted";
    }
}
