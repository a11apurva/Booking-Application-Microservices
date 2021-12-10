package com.upgrad.payment.controller;

import com.upgrad.payment.dto.PaymentDTO;
import com.upgrad.payment.dto.TransactionDetailsDTO;
import com.upgrad.payment.dto.TransactionIdDTO;
import com.upgrad.payment.entity.TransactionDetailsEntity;
import com.upgrad.payment.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     *  Create a transaction
     *
     *  POST - localhost:8082/transaction
     */
    @PostMapping(value = "transaction", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTransaction(@RequestBody PaymentDTO paymentDTO){

        TransactionDetailsEntity newTransactionDetailsEntity = new TransactionDetailsEntity();
        newTransactionDetailsEntity.setPaymentMode(paymentDTO.getPaymentMode());
        newTransactionDetailsEntity.setBookingId(paymentDTO.getBookingId());
        newTransactionDetailsEntity.setUpiId(paymentDTO.getUpiId());
        newTransactionDetailsEntity.setCardNumber(paymentDTO.getCardNumber());

        // save transaction in database
        TransactionDetailsEntity savedTransactionDetailsEntity = paymentService.saveTransaction(newTransactionDetailsEntity);

        // create TransactionIdDTO to return transactionId to the caller
        TransactionIdDTO transactionIdDTO = new TransactionIdDTO(savedTransactionDetailsEntity.getTransactionId());

        return new ResponseEntity(transactionIdDTO, HttpStatus.OK);
    }

    /**
     *  Fetch a transaction
     *
     *  POST - localhost:8082/transaction/{transactionId}
     */
    @GetMapping(value = "transaction/{transactionId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTransactionInfo(@PathVariable(name="transactionId") int transactionId){

        TransactionDetailsEntity transactionDetailsEntity = paymentService.getTransaction(transactionId);
        TransactionDetailsDTO transactionDTO = modelMapper.map(transactionDetailsEntity, TransactionDetailsDTO.class);
        return new ResponseEntity(transactionDTO, HttpStatus.OK);
    }

    /**
     *  Returns all the transactions
     *
     *  GET - localhost:8082/transactions
     */
    @GetMapping(value = "transactions" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fetchAllTransactions(){
        List<TransactionDetailsEntity> transactionDetailsEntities = paymentService.getAllTransactions();
        return new ResponseEntity(transactionDetailsEntities, HttpStatus.OK);
    }

}
