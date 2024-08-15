//package com.hashedin.jobService.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(JobNotFoundException.class)
//    public ResponseEntity<String> handleJobNotFoundException(JobNotFoundException e) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//    }
//
//    @ExceptionHandler(JobAlreadyExistsException.class)
//    public ResponseEntity<String> handleJobAlreadyExistsException(JobAlreadyExistsException e) {
//        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//    }
//
//    @ExceptionHandler(JobUpdateException.class)
//    public ResponseEntity<String> handleJobUpdateException(JobUpdateException e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//    }
//
//    @ExceptionHandler(JobDeleteException.class)
//    public ResponseEntity<String> handleJobDeleteException(JobDeleteException e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//    }
//
//    @ExceptionHandler(JobCreateException.class)
//    public ResponseEntity<String> handleJobCreateException(JobCreateException e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//    }
//}
//
