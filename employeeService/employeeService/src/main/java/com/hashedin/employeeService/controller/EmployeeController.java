package com.hashedin.employeeService.controller;

import com.hashedin.employeeService.entity.Employee;
import com.hashedin.employeeService.exception.EmployeeAlreadyExistsException;
import com.hashedin.employeeService.exception.EmployeeDeleteException;
import com.hashedin.employeeService.exception.EmployeeNotFoundException;
import com.hashedin.employeeService.exception.EmployeeUpdateException;
import com.hashedin.employeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            List<Employee> employees = service.getAllEmployee();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        try {
            Employee employee = service.getEmployeeByID(id);
            return ResponseEntity.ok(employee);
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee createdEmployee = service.createEmployee(employee);
            return ResponseEntity.ok(createdEmployee);
        } catch (EmployeeAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = service.updateEmployee(employee, id);
            return ResponseEntity.ok(updatedEmployee);
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (EmployeeUpdateException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        try {
            service.deleteEmployee(id);
            return ResponseEntity.ok().build();
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (EmployeeDeleteException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
