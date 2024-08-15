package com.hashedin.employeeService.service;

import com.hashedin.employeeService.entity.Employee;
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
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee oldEmployee = employeeRepo.findById(id).orElse(null);
        oldEmployee.setName(employee.getName());
        oldEmployee.setEmail(employee.getEmail());
        oldEmployee.setPhone(employee.getPhone());
        oldEmployee.setDesignation(employee.getDesignation());
        return employeeRepo.save(oldEmployee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }
}
