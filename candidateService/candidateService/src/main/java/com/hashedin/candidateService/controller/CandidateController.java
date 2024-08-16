package com.hashedin.candidateService.controller;

import com.hashedin.candidateService.entity.Candidate;
import com.hashedin.candidateService.exceptions.*;
import com.hashedin.candidateService.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService service;

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> allCandidates = service.getALlCandidates();
        return new ResponseEntity<>(allCandidates, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateByID(@PathVariable int id) {
        try {
            Candidate candidateById = service.getCandidateById(id);
            return new ResponseEntity<>(candidateById, HttpStatus.OK);
        } catch (CandidateNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        try {
            Candidate createdCandidate = service.createCandidate(candidate);
            return new ResponseEntity<>(createdCandidate, HttpStatus.CREATED);
        } catch (CandidateAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (CandidateCreationException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (InvalidCandidateDataException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable int id, @RequestBody Candidate candidate) {
        try {
            Candidate updatedCandidate = service.updateCandidate(candidate, id);
            return new ResponseEntity<>(updatedCandidate, HttpStatus.OK);
        } catch (CandidateNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (CandidateAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (CandidateUpdateException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (InvalidCandidateDataException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable int id) {
        try {
            service.deleteCandidate(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CandidateNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (CandidateDeletionException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
