package com.capstone.Ae_bank.controller;


import com.capstone.Ae_bank.model.CheckingAccount;
import com.capstone.Ae_bank.repositories.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/api/checkingAccounts")
public class CheckingAccountController {
    @Autowired
    private final CheckingAccountRepository checkingAccountRepository;

    public CheckingAccountController(CheckingAccountRepository checkingAccountRepository) {
        this.checkingAccountRepository = checkingAccountRepository;
    }

    @PostMapping("/")
    public ResponseEntity<CheckingAccount> createCheckAccount(@RequestBody CheckingAccount newAccount){
        CheckingAccount a= checkingAccountRepository.save(newAccount);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }


    @GetMapping("/accounts")
    public ResponseEntity<List<CheckingAccount>> getAllAccounts(){
        List<CheckingAccount> accounts = checkingAccountRepository.findAll();
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckingAccount> getAccountById(@PathVariable Long id){
        Optional<CheckingAccount> maybeAccount = checkingAccountRepository.findById(id);
        if(maybeAccount.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(maybeAccount.get(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CheckingAccount> updateChecking(@RequestBody CheckingAccount updateCheck, @PathVariable long id){

        CheckingAccount updateCheckingAcc= checkingAccountRepository.save(updateCheck);
        return new ResponseEntity<>(updateCheckingAcc,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccountById(RestTemplate restTemplate, @PathVariable Long id){

        Optional<CheckingAccount> account = checkingAccountRepository.findById(id);
        if (account.isEmpty()) {

            // System.out.println(id + "did not match any item");
            return new ResponseEntity<CheckingAccount>(HttpStatus.NOT_FOUND);
        }
        checkingAccountRepository.deleteById(id);

        return ResponseEntity.ok(account);


    }



}