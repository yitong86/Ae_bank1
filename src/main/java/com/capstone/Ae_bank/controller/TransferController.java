package com.capstone.Ae_bank.controller;

import com.capstone.Ae_bank.model.CheckingAccount;
import com.capstone.Ae_bank.model.Transaction;
import com.capstone.Ae_bank.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TransferController {
@Autowired
private TransactionRepository repository;
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateChecking(@RequestBody Transaction updateTrans, @PathVariable long id){

        Transaction updateTransf= repository.save(updateTrans);
        return new ResponseEntity<>(updateTransf, HttpStatus.OK);

    }
}
