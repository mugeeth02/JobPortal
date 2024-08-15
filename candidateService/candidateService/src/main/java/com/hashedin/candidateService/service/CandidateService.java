package com.hashedin.candidateService.service;

import com.hashedin.candidateService.entity.Candidate;

import java.util.List;

public interface CandidateService {
    List<Candidate> getALlCandidates();
    Candidate getCandidateById(Integer id);
    Candidate createCandidate(Candidate candidate);
    Candidate updateCandidate(Candidate candidate,int id);
    void deleteCandidate(int id);
}
