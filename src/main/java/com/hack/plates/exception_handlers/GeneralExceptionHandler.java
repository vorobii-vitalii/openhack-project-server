package com.hack.plates.exception_handlers;

import com.hack.plates.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse<String>> handleException(Exception e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponse<String> errorResponse = new ErrorResponse<>(e.getMessage(), httpStatus.value(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

}
