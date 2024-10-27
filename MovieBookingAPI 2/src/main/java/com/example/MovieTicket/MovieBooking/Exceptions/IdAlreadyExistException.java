package com.example.MovieTicket.MovieBooking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdAlreadyExistException extends RuntimeException {
    public IdAlreadyExistException(String message) {
        super(message);
    }
}
