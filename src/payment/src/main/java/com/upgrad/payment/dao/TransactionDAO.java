package com.upgrad.payment.dao;

import com.upgrad.payment.entity.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDAO extends JpaRepository<TransactionDetailsEntity, Integer> {

}
