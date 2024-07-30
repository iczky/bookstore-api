package com.bookstore.demo.exceptions;


import com.bookstore.demo.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.UnknownHostException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> handleDataNotFoundException(DataNotFoundException e) {
        return Response.failedResponse(HttpStatus.NOT_FOUND.value(),"Entity not found", null);
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Response<String>> handleAllExceptions(Exception ex) {

        log.error(ex.getMessage(), ex.getCause(), ex);

        if (ex.getCause() instanceof UnknownHostException) {
            return Response.failedResponse(ex.getLocalizedMessage(), null);
        }

        return Response.failedResponse( "Unable to process " + ex.getMessage(), null);
    }
}
