package com.hashedin.interviewService.controller;

import com.hashedin.interviewService.entity.Interview;
import com.hashedin.interviewService.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interviews")
public class InterviewController {
    @Autowired
    private InterviewService service;

    @GetMapping
    public List<Interview> getAllInterviews(){
        List<Interview> allInterviews = service.getAllInterviews();
        return  allInterviews;
    }

    @GetMapping("/{id}")
    public Interview getInterviewById(@PathVariable int id){
        Interview interviewById = service.getInterviewById(id);
        return interviewById;
    }
    @PostMapping
    public Interview createInterview(@RequestBody Interview interview){
        service.createInterview(interview);
        return interview;
    }
    @PutMapping("/{id}")
    public Interview updateInterview(@PathVariable int id,@RequestBody Interview interview){
        Interview interview1 = service.updateInterview(interview, id);
        return interview1;
    }
    @DeleteMapping("/{id}")
    public void deleteInterview(@PathVariable int id){
        service.deleteInterview(id);
    }
}
