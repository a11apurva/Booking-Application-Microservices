package com.upgrad.payment.entity;

import javax.persistence.*;

@Entity
@Table(name="transaction")
public class TransactionDetailsEntity {

    @Id
    @Column(name = "transactionId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;

    @Column(name = "bookingId", nullable = false)
    private int bookingId;

    @Column(name = "paymentMode")
    private String paymentMode;

    @Column(name = "upiId", nullable = true)
    private String upiId;

    @Column(name = "cardNumber", nullable = true)
    private String cardNumber;

    @Override
    public String toString() {
        return "PaymentTransaction{" +
                "transactionId=" + transactionId +
                ", bookingId=" + bookingId +
                ", paymentMode='" + paymentMode + '\'' +
                ", upiId='" + upiId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
