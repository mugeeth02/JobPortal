package com.hashedin.candidateService.service;

import com.hashedin.candidateService.entity.Candidate;
import com.hashedin.candidateService.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepo;

    @Override
    public List<Candidate> getALlCandidates() {
        return candidateRepo.findAll();
    }

    @Override
    public Candidate getCandidateById(Integer id) {
        return candidateRepo.findById(id).orElse(null);
    }

    @Override
    public Candidate createCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Candidate candidate, int id) {
        Candidate oldCandidate = candidateRepo.findById(id).orElse(null);
        oldCandidate.setName(candidate.getName());
        oldCandidate.setEmail(candidate.getEmail());
        oldCandidate.setPhone(candidate.getPhone());
        oldCandidate.setResume(candidate.getResume());
        return candidateRepo.save(oldCandidate);
    }

    @Override
    public void deleteCandidate(int id) {
        candidateRepo.deleteById(id);
    }
}
