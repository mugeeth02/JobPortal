package com.hashedin.candidateService.repository;

import com.hashedin.candidateService.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
}
