package com.mediTrack.exception;


import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ApiError> buildError(HttpStatus status, String error, String message, WebRequest request){
        ApiError apiError = ApiError.builder()
                .timeStamp(LocalDateTime.now())
                .error(error)
                .message(message)
                .path(request.getDescription(false))
                .status(status.value())
                .build();
        return new ResponseEntity<>(apiError,status);
    }

    @ExceptionHandler(ResourceNotFoundException.class)

}