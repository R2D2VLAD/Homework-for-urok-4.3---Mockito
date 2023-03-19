package com.example.mockito.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoUserException extends RuntimeException {

    public NoUserException(String message) {
        super(message);
    }
}
