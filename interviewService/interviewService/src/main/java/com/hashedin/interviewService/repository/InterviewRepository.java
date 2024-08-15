package com.hashedin.interviewService.repository;

import com.hashedin.interviewService.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview,Integer> {
}
