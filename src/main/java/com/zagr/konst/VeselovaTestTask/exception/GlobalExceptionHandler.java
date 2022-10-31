package com.zagr.konst.VeselovaTestTask.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex) {
        log.error(ex.getLocalizedMessage());

        Map<String, String> errorResponse = new HashMap<>();

        errorResponse.put("message", ex.getLocalizedMessage());
        errorResponse.put("status", HttpStatus.NOT_FOUND.toString());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
