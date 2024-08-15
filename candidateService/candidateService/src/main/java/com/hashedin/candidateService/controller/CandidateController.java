package com.hashedin.candidateService.controller;

import com.hashedin.candidateService.entity.Candidate;
import com.hashedin.candidateService.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService service;

    @GetMapping
    public List<Candidate> getAllCandidates(){
        List<Candidate> aLlCandidates = service.getALlCandidates();
        return aLlCandidates;
    }

    @GetMapping("/{id}")
    public Candidate getCandidateByID(@PathVariable int id){
        Candidate candidateById = service.getCandidateById(id);
        return candidateById;
    }

    @PostMapping
    public Candidate createCandidate(@RequestBody Candidate candidate){
        Candidate candidate1 = service.createCandidate(candidate);
        return candidate1;
    }

    @PutMapping("/{id}")
    public Candidate updateCandidate(@PathVariable int id,@RequestBody Candidate candidate){
        Candidate candidate1 = service.updateCandidate(candidate, id);
        return candidate1;
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable int id){
        service.deleteCandidate(id);
    }
}
