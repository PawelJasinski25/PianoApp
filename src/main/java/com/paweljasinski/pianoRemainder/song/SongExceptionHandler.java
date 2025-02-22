package com.paweljasinski.pianoRemainder.song;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SongExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<SongErrorResponse> handleException(SongNotFoundException exc){
        SongErrorResponse error = new SongErrorResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler
    public ResponseEntity<SongErrorResponse> handleException(Exception exc){
        SongErrorResponse error = new SongErrorResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
