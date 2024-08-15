package com.hashedin.jobService.service;

import com.hashedin.jobService.dto.JobRequestDTO;
import com.hashedin.jobService.dto.JobResponseDTO;
import com.hashedin.jobService.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    Job getJobById(Long id);
    Job createJob(JobRequestDTO job);
    Job updateJob(JobRequestDTO job,Long id);
    void deleteJob(Long id);
}
