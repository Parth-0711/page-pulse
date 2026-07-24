package com.DigitalHeros.page_pulse.exception;

import com.DigitalHeros.page_pulse.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleRuntimeException(
            RuntimeException ex) {

        return ErrorResponse.builder()
                .error(ex.getMessage())
                .build();
    }
}