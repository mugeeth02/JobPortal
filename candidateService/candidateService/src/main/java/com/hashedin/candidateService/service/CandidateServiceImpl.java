package com.hashedin.candidateService.service;

import com.hashedin.candidateService.entity.Candidate;
import com.hashedin.candidateService.exceptions.*;
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
        return candidateRepo.findById(id).orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id: " + id));
    }

    @Override
    public Candidate createCandidate(Candidate candidate) {
        if (candidateRepo.existsByEmail(candidate.getEmail())) {
            throw new CandidateAlreadyExistsException("Candidate already exists with email: " + candidate.getEmail());
        }
        try {
            return candidateRepo.save(candidate);
        } catch (Exception e) {
            throw new CandidateCreationException("Error creating candidate: " + e.getMessage());
        }
    }

    @Override
    public Candidate updateCandidate(Candidate candidate, int id) {
        Candidate oldCandidate = candidateRepo.findById(id).orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id: " + id));
        if (candidate.getEmail() != null && !candidate.getEmail().equals(oldCandidate.getEmail()) && candidateRepo.existsByEmail(candidate.getEmail())) {
            throw new CandidateAlreadyExistsException("Candidate already exists with email: " + candidate.getEmail());
        }
        try {
            oldCandidate.setName(candidate.getName());
            oldCandidate.setEmail(candidate.getEmail());
            oldCandidate.setPhone(candidate.getPhone());
            oldCandidate.setResume(candidate.getResume());
            return candidateRepo.save(oldCandidate);
        } catch (Exception e) {
            throw new CandidateUpdateException("Error updating candidate: " + e.getMessage());
        }
    }

    @Override
    public void deleteCandidate(int id) {
        if (!candidateRepo.existsById(id)) {
            throw new CandidateNotFoundException("Candidate not found with id: " + id);
        }
        try {
            candidateRepo.deleteById(id);
        } catch (Exception e) {
            throw new CandidateDeletionException("Error deleting candidate: " + e.getMessage());
        }
    }
}
