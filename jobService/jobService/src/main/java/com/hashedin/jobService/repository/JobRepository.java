package com.hashedin.jobService.repository;

import com.hashedin.jobService.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {

}
