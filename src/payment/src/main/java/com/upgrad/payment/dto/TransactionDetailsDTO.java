package com.upgrad.payment.dto;

import java.util.Objects;

public class TransactionDetailsDTO {

    private int transactionId;
    private int bookingId;
    private String paymentMode;
    private String upiId;
    private String cardNumber;

    public TransactionDetailsDTO(){}

    public TransactionDetailsDTO(int bookingId, String upiId, String paymentMode, String cardNumber, int transactionId) {
        this.bookingId = bookingId;
        this.upiId = upiId;
        this.paymentMode = paymentMode;
        this.cardNumber = cardNumber;
        this.transactionId = transactionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDetailsDTO that = (TransactionDetailsDTO) o;
        return bookingId == that.bookingId && upiId == that.upiId && transactionId == that.transactionId && Objects.equals(paymentMode, that.paymentMode) && Objects.equals(cardNumber, that.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, upiId, paymentMode, cardNumber, transactionId);
    }

    @Override
    public String toString() {
        return "TransactionDetailsEntity{" +
                "bookingId=" + bookingId +
                ", upiId=" + upiId +
                ", paymentMode='" + paymentMode + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", transactionId=" + transactionId +
                '}';
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
