package com.hashedin.employeeService.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}