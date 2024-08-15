package com.hashedin.interviewService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewRequestDTO {
    private Integer jobId;
    private Integer candidateId;
    private LocalDate date;
    private LocalTime time;
    private String status;
}
