package com.viborotto.explorandomarte.model;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ResponseBaseError {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ResponseBaseError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ResponseBaseError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}
