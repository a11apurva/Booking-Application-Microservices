package com.upgrad.payment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PaymentExceptionHandler {


    @ExceptionHandler(PaymentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> processValidationError(PaymentException ex) {
        return new ResponseEntity<>(ex.toString(), HttpStatus.BAD_REQUEST);
    }

    /*
    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<String> handleExecutionRestrictionViolationException(PaymentException ex) {
        return response(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private static String createJson(String message) {
        return "{\"message\" : \"" + message + "\"," +
                "\"statusCode\" : \"400\"}";
    }

    private static ResponseEntity<String> response(String message,
                                                   HttpStatus httpStatus) {
        String json = createJson(message);
        return new ResponseEntity<>(json, httpStatus);
    }
     */



}
