package com.example.hr.exception.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private static final String DEFAULT_ERROR_MESSAGE = "ERROR!!";

    private String message;
    private int statusCode;
    private HttpStatus status;
    private LocalDateTime timestamp;

    private ErrorResponse(final String message){
        this.message = message;
        this.statusCode = HttpStatus.BAD_REQUEST.value();
        this.status = HttpStatus.BAD_REQUEST;
        this.timestamp = LocalDateTime.now();
    }

    private ErrorResponse(final String message, final HttpStatus status){
        this.message = message;
        this.statusCode = status.value();
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public static ErrorResponse from(String message){
        return new ErrorResponse(message);
    }

    public static ErrorResponse of(String message, HttpStatus status){
        return new ErrorResponse(message, status);
    }

}
