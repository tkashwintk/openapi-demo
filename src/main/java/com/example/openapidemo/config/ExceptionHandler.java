package com.example.openapidemo.config;

import com.example.openapidemo.exception.CustomerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Error> handleUserNotFoundException(CustomerNotFoundException exception) {
        log.error("************ Not Found");
        return (ResponseEntity<Error>) ResponseEntity.ok();
    }


}
