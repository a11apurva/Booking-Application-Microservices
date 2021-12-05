package com.upgrad.Booking.exceptions.dto;

public class ErrorResponse {

    private String message;
    private int code;

    public ErrorResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
