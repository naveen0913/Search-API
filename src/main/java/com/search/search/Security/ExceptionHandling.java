package com.search.search.Security;

import com.search.search.Responses.CustomResponse;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        CustomResponse customResponse = new CustomResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage(), null
        );
        return  ResponseEntity.badRequest().body(customResponse);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleException(Exception e) {

        CustomResponse customResponse = new CustomResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null
        );
        return  ResponseEntity.internalServerError().body(customResponse);
    }

}
