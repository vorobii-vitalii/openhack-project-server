package com.hack.plates.exception_handlers;

import com.hack.plates.entity.ErrorResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Order(1)
@Component
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationException(MethodArgumentNotValidException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Map<String, String> errorMap = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();
        errorMap.put("mainCause", bindingResult.getAllErrors().get(0).getDefaultMessage());
        for (FieldError error : bindingResult.getFieldErrors() ) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }
        ErrorResponse<Map<String, String>> errorResponse = new ErrorResponse<>(
                errorMap, httpStatus.value(), System.currentTimeMillis() );
        return new ResponseEntity(errorResponse, httpStatus);
    }

}
