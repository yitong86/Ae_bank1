package org.yitongJiang.Ae_bank.controller;

import org.yitongJiang.Ae_bank.auth.User;
import org.yitongJiang.Ae_bank.model.Customer;
import org.yitongJiang.Ae_bank.repositories.CustomerRepository;
import org.yitongJiang.Ae_bank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
//customer controllers get update delect save
@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/newCustomer")

    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userDetails = (User) authentication.getPrincipal();

        User currentUser = userRepository.findById(userDetails.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        newCustomer.setUser(currentUser);
        Customer c = customerRepository.save(newCustomer);
        System.out.println(c);
        return new ResponseEntity<>(customerRepository.save(newCustomer), HttpStatus.CREATED);

    }

    @GetMapping("/customers")
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