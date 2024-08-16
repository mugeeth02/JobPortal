package com.hashedin.interviewService.exception;

public class InterviewDeleteException extends RuntimeException {
    public InterviewDeleteException(String message, Exception e) {
        super(message);
    }
}
