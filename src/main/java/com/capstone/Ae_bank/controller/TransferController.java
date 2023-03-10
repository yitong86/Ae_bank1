package com.capstone.Ae_bank.controller;

import com.capstone.Ae_bank.model.CheckingAccount;
import com.capstone.Ae_bank.model.Transaction;
import com.capstone.Ae_bank.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transfer")
public class TransferController {
@Autowired
private TransactionRepository repository;
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateChecking(@RequestBody Transaction updateTrans, @PathVariable long id){

        Transaction updateTransfer= repository.save(updateTrans);
        return new ResponseEntity<>(updateTransfer, HttpStatus.OK);

    }
}
