package com.capstone.Ae_bank.controller;



import com.capstone.Ae_bank.model.CreditCard;
import com.capstone.Ae_bank.repositories.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/creditcards")
public class CreditCardController {
    @Autowired
    private CreditCardRepository creditCardRepository;
    @PostMapping("/")
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCard newCreditCard){
        CreditCard a= creditCardRepository.save(newCreditCard);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<CreditCard>> getAllCreditCards(){
        List<CreditCard> creditCards = creditCardRepository.findAll();
        return new ResponseEntity<>(creditCards,HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CreditCard> getCreditCardById(@PathVariable Long id){
        Optional<CreditCard> oneCard = creditCardRepository.findById(id);
        if(oneCard .isEmpty()){
            return new ResponseEntity<CreditCard>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(oneCard.get(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CreditCard> updateCard(@RequestBody CreditCard updateCreditCard, @PathVariable long id){

        CreditCard updateCredit= creditCardRepository.save(updateCreditCard);
        return new ResponseEntity<>(updateCredit,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCreditCardById(RestTemplate restTemplate, @PathVariable Long id){

        Optional<CreditCard> creditCard1= creditCardRepository.findById(id);
        if (creditCard1.isEmpty()) {

            // System.out.println(id + "did not match any item");
            return new ResponseEntity<CreditCard>(HttpStatus.NOT_FOUND);
        }
        creditCardRepository.deleteById(id);

        return ResponseEntity.ok(creditCard1);


    }
}
