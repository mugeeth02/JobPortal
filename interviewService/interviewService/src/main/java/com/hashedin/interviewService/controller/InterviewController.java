package com.hashedin.interviewService.controller;

import com.hashedin.interviewService.entity.Interview;
import com.hashedin.interviewService.exception.InterviewAlreadyExistsException;
import com.hashedin.interviewService.exception.InterviewDeleteException;
import com.hashedin.interviewService.exception.InterviewNotFoundException;
import com.hashedin.interviewService.exception.InterviewUpdateException;
import com.hashedin.interviewService.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interviews")
public class InterviewController {
    @Autowired
    private InterviewService service;

    @GetMapping
    public ResponseEntity<List<Interview>> getAllInterviews(){
        try {
            List<Interview> allInterviews = service.getAllInterviews();
            return ResponseEntity.ok(allInterviews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interview> getInterviewById(@PathVariable int id){
        try {
            Interview interviewById = service.getInterviewById(id);
            return ResponseEntity.ok(interviewById);
        } catch (InterviewNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Interview> createInterview(@RequestBody Interview interview){
        try {
            Interview createdInterview = service.createInterview(interview);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdInterview);
        } catch (InterviewAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interview> updateInterview(@PathVariable int id, @RequestBody Interview interview){
        try {
            Interview updatedInterview = service.updateInterview(interview, id);
            return ResponseEntity.ok(updatedInterview);
        } catch (InterviewNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (InterviewUpdateException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterview(@PathVariable int id){
        try {
            service.deleteInterview(id);
            return ResponseEntity.noContent().build();
        } catch (InterviewNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (InterviewDeleteException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
