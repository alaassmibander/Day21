package com.example.day21.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}