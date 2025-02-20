package org.javaacademy.tasko.controller;

import lombok.extern.slf4j.Slf4j;
import org.javaacademy.tasko.dto.ErrorRes;
import org.javaacademy.tasko.exception.InvalidTokenException;
import org.javaacademy.tasko.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({
            NotFoundException.class
    })
    public ResponseEntity<?> handleNotFoundException(RuntimeException e) {
        log.warn(e.getMessage(), e);
        return buildErrorRes(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler({
            InvalidTokenException.class
    })
    public ResponseEntity<?> handleTokenException(RuntimeException e) {
        log.warn(e.getMessage(), e);
        return buildErrorRes(HttpStatus.FORBIDDEN, e.getMessage());
    }

    private ResponseEntity<ErrorRes> buildErrorRes(HttpStatus status, String message) {
        return ResponseEntity
                .status(status)
                .body(new ErrorRes(status.value(), status.name(), message));
    }
}
