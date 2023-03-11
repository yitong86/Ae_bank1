package com.capstone.Ae_bank.repositories;

import com.capstone.Ae_bank.model.CheckingAccount;
import com.capstone.Ae_bank.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class CheckingAccountRepositoryTest {
    @Autowired
    private CheckingAccountRepository repository;


    @Test
    public void saveChecking(){
        CheckingAccount checkingAccount = CheckingAccount.builder()
                        .previousTransaction(20)
                                .build();
        repository.save(checkingAccount);
        Assertions.assertThat(checkingAccount.getId()).isGreaterThan(0);
    }
    @Test
    public void getListOfCheckingTest(){
        List<CheckingAccount> checkingAccounts = repository.findAll();
        Assertions.assertThat(checkingAccounts.size()).isGreaterThan(0);
    }
    @Test
    public void updateCheckingTest() {
        CheckingAccount checkingAccount = repository.findById(1L).orElse(new CheckingAccount());
        checkingAccount.setPostDate("09/09/2022");
        CheckingAccount checkingAccountUpdated = repository.save(checkingAccount);
        Assertions.assertThat(checkingAccountUpdated.getPostDate()).isEqualTo("09/09/2022");

    }
    @Test
    public void deleteCustomerTest(){
        CheckingAccount checkingAccount = repository.findById(1L).orElse(new CheckingAccount());
        repository.delete(checkingAccount);

        CheckingAccount checkingAccount1= null;
        Optional<CheckingAccount> optionalChecking = repository.findById(1L);
        if(optionalChecking.isPresent()){
            checkingAccount1 = optionalChecking.get();
            Assertions.assertThat(checkingAccount1).isNull();
        }
    }
}