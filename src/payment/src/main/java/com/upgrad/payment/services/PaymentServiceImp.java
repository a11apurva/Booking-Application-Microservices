package com.upgrad.payment.services;

import com.upgrad.payment.dao.TransactionDAO;
import com.upgrad.payment.entity.TransactionDetailsEntity;
import com.upgrad.payment.exceptions.PaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImp implements PaymentService{

    @Autowired
    public TransactionDAO _transactionDAO;

    @Override
    public TransactionDetailsEntity saveTransaction(TransactionDetailsEntity transactionDetailsEntity) {
        return _transactionDAO.save(transactionDetailsEntity);
    }

    @Override
    public TransactionDetailsEntity getTransaction(int id) {

        Optional<TransactionDetailsEntity> obj = _transactionDAO.findById(id);

        if(!obj.isPresent())
        {
            throw new PaymentException(" Invalid Payment Id ", 400);
        }

        return obj.get();
    }

    @Override
    public List<TransactionDetailsEntity> getAllTransactions() {
        return _transactionDAO.findAll();
    }
}
