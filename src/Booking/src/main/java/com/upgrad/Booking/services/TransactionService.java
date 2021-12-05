package com.upgrad.Booking.services;

import com.upgrad.Booking.dto.PaymentDTO;

public interface TransactionService {
    public int getTransactionNumber(PaymentDTO paymentDTO);
}
