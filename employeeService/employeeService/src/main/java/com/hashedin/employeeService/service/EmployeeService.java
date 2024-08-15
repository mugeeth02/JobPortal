package com.hashedin.employeeService.service;

import com.hashedin.employeeService.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeByID(int id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee,int id);
    void deleteEmployee(int id);
}
