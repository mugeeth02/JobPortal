package com.hashedin.interviewService.service;

import com.hashedin.interviewService.entity.Interview;
import com.hashedin.interviewService.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepository repo;

    @Override
    public List<Interview> getAllInterviews() {
        return repo.findAll();
    }

    @Override
    public Interview getInterviewById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Interview createInterview(Interview interview) {
        return repo.save(interview);
    }

    @Override
    public Interview updateInterview(Interview interview, int id) {
        Interview oldInterview = repo.findById(id).orElse(null);
        oldInterview.setJobId(interview.getJobId());
        oldInterview.setCandidateId(interview.getCandidateId());
        oldInterview.setDate(interview.getDate());
        oldInterview.setTime(interview.getTime());
        oldInterview.setStatus(interview.getStatus());
        return repo.save(oldInterview);
    }

    @Override
    public void deleteInterview(int id) {
        repo.deleteById(id);
    }
}
