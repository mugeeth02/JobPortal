package com.hashedin.employeeService.controller;

import com.hashedin.employeeService.entity.Employee;
import com.hashedin.employeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getALlEmployees(){
        List<Employee> employees = service.getAllEmployee();
        return employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee employee = service.getEmployeeByID(id);
        return employee;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        Employee employee1 = service.createEmployee(employee);
        return employee1;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        Employee employee1 = service.updateEmployee(employee, id);
        return employee1;
    }

    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable int id){
        service.deleteEmployee(id);
    }


}
