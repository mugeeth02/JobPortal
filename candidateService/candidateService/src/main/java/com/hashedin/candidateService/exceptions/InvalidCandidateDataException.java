package com.hashedin.candidateService.exceptions;

public class InvalidCandidateDataException extends RuntimeException {
    public InvalidCandidateDataException(String message) {
        super(message);
    }
}
