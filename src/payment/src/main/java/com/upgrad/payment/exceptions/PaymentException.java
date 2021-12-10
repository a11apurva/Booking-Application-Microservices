package com.upgrad.payment.exceptions;

public class PaymentException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private int statusCode;
    private String message;

    public PaymentException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "\"statusCode\":" + statusCode +
                ", \"message\":\"" + message + '\"' +
                "}";
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
