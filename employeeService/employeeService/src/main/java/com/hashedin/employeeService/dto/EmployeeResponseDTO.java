package com.hashedin.employeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String designation;
}
