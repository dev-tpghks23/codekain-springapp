package com.app.springapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MyPageException extends RuntimeException {
    private final HttpStatus httpStatus;

    public MyPageException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}