package com.upgrad.Booking.dto;

import java.util.Objects;

public class PaymentDTO {

    private int bookingId;
    private String upiId;
    private String paymentMode;
    private String cardNumber;

    public PaymentDTO(int bookingId, String upiId, String paymentMode, String cardNumber) {
        this.bookingId = bookingId;
        this.upiId = upiId;
        this.paymentMode = paymentMode;
        this.cardNumber = cardNumber;
    }

    public PaymentDTO(){};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDTO that = (PaymentDTO) o;
        return bookingId == that.bookingId && upiId == that.upiId && Objects.equals(paymentMode, that.paymentMode) && Objects.equals(cardNumber, that.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, upiId, paymentMode, cardNumber);
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "bookingId=" + bookingId +
                ", upiId=" + upiId +
                ", paymentMode='" + paymentMode + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
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
}
