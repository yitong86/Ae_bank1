package com.capstone.Ae_bank.repositories;

import com.capstone.Ae_bank.model.CheckingAccount;
import com.capstone.Ae_bank.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveCustomer(){
        Customer customer = Customer.builder()
                .email("s@gmail.com")
                .name("ko")
                .id(21)
                .phoneNumber("4012222222").dateOfBirth("09/09/2022").build();
        customerRepository.save(customer);
        Assertions.assertThat(customer.getId()).isGreaterThan(0);
    }
    @Test
    @Order(2)
    @Rollback(value = false)
    void getCustomerById() {
        Customer  customer = customerRepository.findById(1L).orElse(new Customer());

        Assertions.assertThat(customer.getId()).isEqualTo(0L);
    }



    @Test
    @Order(3)
    @Rollback(value = false)
    public void getListOfCustomerTest(){

        List<Customer> customers = customerRepository.findAll();

        Assertions.assertThat(customers.size()).isGreaterThan(0);

    }
    @Test
    @Order(4)
    @Rollback(value = false)
    void updateCustomerTest() {
        Customer  customer = customerRepository.findById(1L).orElse(new Customer());
        customer.setEmail("ll@gmail.com");
        Customer customerUpdated = customerRepository.save(customer);
        Assertions.assertThat(customerUpdated.getEmail()).isEqualTo("ll@gmail.com");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteCustomerTest(){
        Customer customer = customerRepository.findById(1L).orElse(new Customer());
        customerRepository.delete(customer);
        //customerRepository.deleteById(1L);
        Customer customer1 = null;
       Optional <Customer> optionalCustomer = customerRepository.findById(1L);
        if(optionalCustomer.isPresent()){
            customer1 = optionalCustomer.get();
            Assertions.assertThat(customer1).isNull();
        }
    }
}