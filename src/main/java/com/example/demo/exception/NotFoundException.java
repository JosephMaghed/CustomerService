package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;


public class NotFoundException extends RuntimeException {

    public  NotFoundException(String message) {
        super(message);
    }
}
