package com.example.hr.exception;

import com.example.hr.exception.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = BizException.class)
    public ResponseEntity<ErrorResponse> bizException(BizException e){
        return errorResponse(ErrorResponse.of(e.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(NotFoundException e){
        return errorResponse(ErrorResponse.of(e.getMessage(), HttpStatus.NOT_FOUND));
    }

    private ResponseEntity<ErrorResponse> errorResponse(final ErrorResponse response){
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
