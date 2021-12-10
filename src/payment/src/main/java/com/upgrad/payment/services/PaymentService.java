package com.upgrad.payment.services;

import com.upgrad.payment.entity.TransactionDetailsEntity;

import java.util.List;

public interface PaymentService {

    public TransactionDetailsEntity saveTransaction(TransactionDetailsEntity transactionDetailsEntity);

    public TransactionDetailsEntity getTransaction(int id);

    public List<TransactionDetailsEntity> getAllTransactions();
}
