package com.hashedin.interviewService.service;

import com.hashedin.interviewService.entity.Interview;

import java.util.List;

public interface InterviewService {
    List<Interview> getAllInterviews();
    Interview getInterviewById(int id);
    Interview createInterview(Interview interview);
    Interview updateInterview(Interview interview,int id);
    void deleteInterview(int id);
}
