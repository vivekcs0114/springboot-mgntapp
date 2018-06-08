package com.synerzip.college.repository;

import com.synerzip.college.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e, Department d WHERE d.id = e.department AND d.id = ?1")
    public List<Employee> getAllEmployeeFromDepartment(Integer depId);
}
