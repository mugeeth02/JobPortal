package com.hashedin.interviewService.exception;

public class InterviewAlreadyExistsException extends RuntimeException {
    public InterviewAlreadyExistsException(String message) {
        super(message);
    }
}
