package org.yitongJiang.Ae_bank.controller;


import org.yitongJiang.Ae_bank.model.SavingAccount;
import org.yitongJiang.Ae_bank.repositories.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
//checking account controllers get update delect save
@CrossOrigin
@RestController
@RequestMapping("/api/savingAccounts")
public class SavingAccountController {
    @Autowired
    private SavingAccountRepository savingAccountRepository;
    @PostMapping("/")
    public ResponseEntity<SavingAccount> createSavingAccount(@RequestBody SavingAccount newAccount){
        SavingAccount a= savingAccountRepository.save(newAccount);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }


    @GetMapping("/accounts")
    public ResponseEntity<List<SavingAccount>> getAllAccounts(){
        List<SavingAccount> accounts = savingAccountRepository.findAll();
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingAccount> getAccountById(@PathVariable Long id){
        Optional<SavingAccount> maybeAccount = savingAccountRepository.findById(id);
        if(maybeAccount.isEmpty()){
            return new ResponseEntity<SavingAccount>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(maybeAccount.get(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavingAccount> updateSaving(@RequestBody SavingAccount updateSaving, @PathVariable long id){

        SavingAccount updateSavingAcc= savingAccountRepository.save(updateSaving);
        return new ResponseEntity<>(updateSavingAcc,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccountById(RestTemplate restTemplate, @PathVariable Long id){

        Optional<SavingAccount> account = savingAccountRepository.findById(id);
        if (account.isEmpty()) {

            // System.out.println(id + "did not match any item");
            return new ResponseEntity<SavingAccount>(HttpStatus.NOT_FOUND);
        }
        savingAccountRepository.deleteById(id);

        return ResponseEntity.ok(account);


    }



}

