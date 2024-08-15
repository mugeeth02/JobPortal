package com.hashedin.interviewService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "interviews")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Interview implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "job_id")
    private Integer jobId;
    @Column(name = "candidate_id")
    private Integer candidateId;
    @Column(name = "interview_date")
    private LocalDate date;
    @Column(name = "interview_time")
    private LocalTime time;
    @Column(name = "status")
    private String status;

}
