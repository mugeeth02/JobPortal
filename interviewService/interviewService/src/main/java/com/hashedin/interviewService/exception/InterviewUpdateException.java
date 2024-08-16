package com.hashedin.interviewService.exception;

public class InterviewUpdateException extends RuntimeException {
    public InterviewUpdateException(String message, Exception e) {
        super(message);
    }
}