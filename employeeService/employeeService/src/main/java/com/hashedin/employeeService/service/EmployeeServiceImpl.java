package com.hashedin.employeeService.service;

import com.hashedin.employeeService.entity.Employee;
import com.hashedin.employeeService.exception.EmployeeAlreadyExistsException;
import com.hashedin.employeeService.exception.EmployeeDeleteException;
import com.hashedin.employeeService.exception.EmployeeNotFoundException;
import com.hashedin.employeeService.exception.EmployeeUpdateException;
import com.hashedin.employeeService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public List<Employee> getAllEmployee() {
        try {
            return employeeRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching all employees: " + e.getMessage());
        }
    }

    @Override
    public Employee getEmployeeByID(int id) {
        try {
            return employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error fetching employee by id: " + e.getMessage());
        }
    }

    @Override
    public Employee createEmployee(Employee employee) {
        try {
            if (employeeRepo.existsByEmail(employee.getEmail())) {
                throw new EmployeeAlreadyExistsException("Employee already exists with email: " + employee.getEmail());
            }
            return employeeRepo.save(employee);
        } catch (Exception e) {
            throw new RuntimeException("Error creating employee: " + e.getMessage());
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        try {
            Employee oldEmployee = employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
            oldEmployee.setName(employee.getName());
            oldEmployee.setEmail(employee.getEmail());
            oldEmployee.setPhone(employee.getPhone());
            oldEmployee.setDesignation(employee.getDesignation());
            return employeeRepo.save(oldEmployee);
        } catch (Exception e) {
            throw new EmployeeUpdateException("Error updating employee: " + e.getMessage());
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            employeeRepo.deleteById(id);
        } catch (Exception e) {
            throw new EmployeeDeleteException("Error deleting employee: " + e.getMessage());
        }
    }
}
