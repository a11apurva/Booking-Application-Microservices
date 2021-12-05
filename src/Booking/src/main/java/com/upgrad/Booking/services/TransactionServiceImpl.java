package com.upgrad.Booking.services;

import com.upgrad.Booking.dto.PaymentDTO;
import com.upgrad.Booking.dto.TransactionIdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public int getTransactionNumber(PaymentDTO paymentDTO) {

        String paymentUri = "http://localhost:8083/transaction";
        TransactionIdDTO transactionIdDTO = restTemplate.postForObject(paymentUri, paymentDTO, TransactionIdDTO.class);

        if(transactionIdDTO == null)
            return 0;

        return transactionIdDTO.getTransactionId();
    }
}
