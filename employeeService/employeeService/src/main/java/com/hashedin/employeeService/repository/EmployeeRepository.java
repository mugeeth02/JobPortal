package com.hashedin.employeeService.repository;

import com.hashedin.employeeService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    boolean existsByEmail(String email);
}
