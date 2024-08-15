package com.hashedin.jobService.controller;

import com.hashedin.jobService.dto.JobRequestDTO;
import com.hashedin.jobService.dto.JobResponseDTO;
import com.hashedin.jobService.entity.Job;
import com.hashedin.jobService.service.JobService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@Api(value = "Job Controller", description = "REST API for Job Management")
public class JobController {


    @Autowired
    private JobService jobService;

    @GetMapping
    @ApiOperation(value = "Get all jobs", notes = "Returns a list of all jobs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jobs retrieved successfully"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public JobResponseDTO<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return new JobResponseDTO<>(true, jobs, "Jobs retrieved successfully");
    }

    @GetMapping("/{jobId}")
    @ApiOperation(value = "Get job by ID", notes = "Returns a job by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Job retrieved successfully"),
            @ApiResponse(code = 404, message = "Job not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public JobResponseDTO<Job> getJobById(@ApiParam(value = "Job ID", required = true) @PathVariable Long id){
        Job job = jobService.getJobById(id);
        return new JobResponseDTO<>(true,job,"Job retrieved successfully");
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiOperation(value = "Create a new job", notes = "Creates a new job with the provided details")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Job created successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public JobResponseDTO<Job> createJob(@ApiParam(value = "Job details", required = true) @RequestBody JobRequestDTO jobRequestDTO){
        Job createdJob = jobService.createJob(jobRequestDTO);
        return new JobResponseDTO<>(true,createdJob,"Job Created Successfully");
    }

    @PutMapping("/{jobId}")
    @ApiOperation(value = "Update a job", notes = "Updates a job with the provided details")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Job updated successfully"),
            @ApiResponse(code = 404, message = "Job not found"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public JobResponseDTO<Job> updateJob(@ApiParam(value = "Job ID", required = true) @PathVariable Long id,
                                         @ApiParam(value = "Job details", required = true) @RequestBody JobRequestDTO jobRequestDTO) {
        Job updatedJob = jobService.updateJob(jobRequestDTO, id);
        return new JobResponseDTO<>(true, updatedJob, "Job updated successfully");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a job", notes = "Deletes a job by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Job deleted successfully"),
            @ApiResponse(code = 404, message = "Job not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public JobResponseDTO<?> deleteJob(@ApiParam(value = "Job ID", required = true)@PathVariable Long id){
        jobService.deleteJob(id);
        return new JobResponseDTO<>(true,null,"Job Deleted Successfully");
    }
}
