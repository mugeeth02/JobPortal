package com.hashedin.jobService.service;

import com.hashedin.jobService.dto.JobRequestDTO;
import com.hashedin.jobService.entity.Job;
import com.hashedin.jobService.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepo;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<Job> getAllJobs() {
        try {
            log.info("Fetching all jobs");
            List<Job> jobs = jobRepo.findAll();
            log.debug("Fetched {} jobs", jobs.size());
            return jobs;
        } catch (Exception e) {
            log.error("Error fetching all jobs: {}", e.getMessage());
            throw new RuntimeException("Error fetching all jobs: " + e.getMessage());
        }
    }

    @Override
    public Job getJobById (Long id){
        try {
            log.info("Fetching job by id: {}", id);
            Job job = jobRepo.findById(id).orElse(null);
            if (job != null) {
                log.debug("Fetched job: {}", job.getTitle());
            } else {
                log.warn("Job not found with id: {}", id);
            }
            return job;
        } catch (Exception e) {
            log.error("Error fetching job by id: {}", e.getMessage());
            throw new RuntimeException("Error fetching job by id: " + e.getMessage());
        }
    }
    //create local variable & use try catch & modelmappers

    @Override
    public Job createJob (JobRequestDTO jobRequestDTO){
        try {
            log.info("Creating job: {}", jobRequestDTO.getTitle());
            Job job = mapper.map(jobRequestDTO, Job.class);
            Job createdJob = jobRepo.save(job);
            log.debug("Created job: {}", createdJob.getTitle());
            return createdJob;
        } catch (Exception e) {
            log.error("Error creating job: {}", e.getMessage());
            throw new RuntimeException("Error creating job: " + e.getMessage());
        }
    }

    @Override
    public Job updateJob(JobRequestDTO jobRequestDTO, Long id){
        try {
            log.info("Updating job: {}", id);
            Job existingJob = jobRepo.findById(id).orElse(null);
            if (existingJob != null) {
                existingJob.setTitle(jobRequestDTO.getTitle());
                existingJob.setDescription(jobRequestDTO.getDescription());
//                existingJob.setSalary(jobRequestDTO.getSalary());
                Job updatedJob = null;
                log.debug("Updated job: {}", updatedJob.getTitle());
                updatedJob = jobRepo.save(existingJob);
                return updatedJob;
            } else {
                log.warn("Job not found with id: {}", id);
                throw new RuntimeException("Job not found with id: " + id);
            }
        } catch (Exception e) {
            log.error("Error updating job: {}", e.getMessage());
            throw new RuntimeException("Error updating job: " + e.getMessage());
        }
    }

    @Override
    public void deleteJob (Long id){
        try {
            log.info("Deleting job: {}", id);
            jobRepo.deleteById(id);
            log.debug("Deleted job: {}", id);
        } catch (Exception e) {
            log.error("Error deleting job: {}", e.getMessage());
            throw new RuntimeException("Error deleting job: " + e.getMessage());
        }
    }
}
