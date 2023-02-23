package com.capstone.Ae_bank.controller;


import com.capstone.Ae_bank.model.Account;
import com.capstone.Ae_bank.model.Loan;
import com.capstone.Ae_bank.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/loans")
public class LoanController {
    @Autowired
    private LoanRepository loanRepository;
    @PostMapping("/")
    public ResponseEntity<Loan> createLoan(@RequestBody Loan newLoan){
        Loan loan= loanRepository.save(newLoan);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Loan>> getAllLoans(){
        List<Loan> loans = loanRepository.findAll();
        return new ResponseEntity<>(loans,HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id){
        Optional<Loan> maybeLoan = loanRepository.findById(id);
        if(maybeLoan.isEmpty()){
            return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(maybeLoan.get(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoanAccount(@RequestBody Loan updateLoan, @PathVariable long id){

        Loan updateLoanAcc= loanRepository.save(updateLoan);
        return new ResponseEntity<>(updateLoanAcc,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLoanById(RestTemplate restTemplate, @PathVariable Long id){

        Optional<Loan> maybeLoan = loanRepository.findById(id);
        if (maybeLoan.isEmpty()) {

           // System.out.println(id + "did not match any item");
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        loanRepository.deleteById(id);

        return ResponseEntity.ok(maybeLoan);


    }




}
