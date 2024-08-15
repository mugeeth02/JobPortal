package com.hashedin.jobService.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobResponseDTO<T> {
    private Boolean success;
    private T data;
    private String message;
}
