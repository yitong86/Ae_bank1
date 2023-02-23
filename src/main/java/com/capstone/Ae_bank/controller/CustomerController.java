package com.capstone.Ae_bank.controller;

import com.capstone.Ae_bank.model.Customer;
import com.capstone.Ae_bank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newUser) {
        Customer c = customerRepository.save(newUser);
        System.out.println(c);
        return new ResponseEntity<>(c, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> users = customerRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getOneUser(@PathVariable long id){
        Optional<Customer> maybeCustomer = customerRepository.findById(id);
        if(maybeCustomer.isEmpty()){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(maybeCustomer.get(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer updateUser, @PathVariable long id){

        Customer saveUser = customerRepository.save(updateUser);
        return new ResponseEntity<>(saveUser,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    //<void> no return
    public ResponseEntity<?> deleteCustomerById(RestTemplate restTemplate, @PathVariable Long id){

        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            // System.out.println(id + "did not match any item");

        }
        customerRepository.deleteById(id);


        return ResponseEntity.ok(customer);


    }
}