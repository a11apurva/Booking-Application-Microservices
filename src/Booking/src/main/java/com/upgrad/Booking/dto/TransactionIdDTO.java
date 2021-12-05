package com.upgrad.Booking.dto;

import java.util.Objects;

public class TransactionIdDTO {

    private int transactionId;

    public TransactionIdDTO(int transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionIdDTO(){};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionIdDTO that = (TransactionIdDTO) o;
        return transactionId == that.transactionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId);
    }

    @Override
    public String toString() {
        return "TransactionIdDTO{" +
                "transactionId=" + transactionId +
                '}';
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
