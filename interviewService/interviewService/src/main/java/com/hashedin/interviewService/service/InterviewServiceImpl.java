package com.hashedin.interviewService.service;

import com.hashedin.interviewService.entity.Interview;
import com.hashedin.interviewService.exception.InterviewAlreadyExistsException;
import com.hashedin.interviewService.exception.InterviewDeleteException;
import com.hashedin.interviewService.exception.InterviewNotFoundException;
import com.hashedin.interviewService.exception.InterviewUpdateException;
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
        try {
            return repo.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching interviews", e);
        }
    }

    @Override
    public Interview getInterviewById(int id) {
        return repo.findById(id).orElseThrow(() -> new InterviewNotFoundException("Interview not found with id: " + id));
    }

    @Override
    public Interview createInterview(Interview interview) {
        try {
            if (repo.existsByJobIdAndCandidateId(interview.getJobId(), interview.getCandidateId())) {
                throw new InterviewAlreadyExistsException("Interview already exists for this job and candidate");
            }
            return repo.save(interview);
        } catch (Exception e) {
            throw new RuntimeException("Error creating interview", e);
        }
    }

    @Override
    public Interview updateInterview(Interview interview, int id) {
        try {
            Interview oldInterview = repo.findById(id).orElseThrow(() -> new InterviewNotFoundException("Interview not found with id: " + id));
            oldInterview.setJobId(interview.getJobId());
            oldInterview.setCandidateId(interview.getCandidateId());
            oldInterview.setDate(interview.getDate());
            oldInterview.setTime(interview.getTime());
            oldInterview.setStatus(interview.getStatus());
            return repo.save(oldInterview);
        } catch (Exception e) {
            throw new InterviewUpdateException("Error updating interview", e);
        }
    }

    @Override
    public void deleteInterview(int id) {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new InterviewDeleteException("Error deleting interview",e);
        }
    }
}
