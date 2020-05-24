package com.hack.plates.exception_handlers;

import com.hack.plates.entity.ErrorResponse;
import com.hack.plates.exceptions.users.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse<String>> handleUserNotFound(UserNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponse<String> errorResponse = new ErrorResponse<>(
                e.getMessage(), httpStatus.value(), System.currentTimeMillis() );
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

}
