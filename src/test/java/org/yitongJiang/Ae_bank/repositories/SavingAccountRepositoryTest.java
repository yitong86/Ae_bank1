package org.yitongJiang.Ae_bank.repositories;



import org.yitongJiang.Ae_bank.model.SavingAccount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SavingAccountRepositoryTest {
    @Autowired
    private SavingAccountRepository repository;


    @Test
    public void saving(){
        SavingAccount savingAccount = SavingAccount.builder()
                        .interestRate(0.02)
                                .previousTransaction(30)
                                        .build();
        repository.save(savingAccount);
        Assertions.assertThat(savingAccount.getId()).isGreaterThan(0);
    }
    @Test
    public void getListOfSavingTest(){
        List<SavingAccount> savingAccounts = repository.findAll();
        Assertions.assertThat(savingAccounts.size()).isGreaterThan(0);
    }

    @Test
    public void updateSavingTest() {
        SavingAccount savingAccount =  repository.findById(1L).orElse(new SavingAccount());
        savingAccount.setPostDate("09/09/2022");
        SavingAccount savingAccountUpdated = repository.save(savingAccount);
        Assertions.assertThat(savingAccountUpdated.getPostDate()).isEqualTo("09/09/2022");

    }
    @Test
    public void deleteCustomerTest(){
        SavingAccount savingAccount = repository.findById(1L).orElse(new SavingAccount());
        repository.delete(savingAccount);

        SavingAccount savingAccount1= null;
        Optional<SavingAccount> optionalSaving = repository.findById(1L);
        if(optionalSaving.isPresent()){
            savingAccount1 = optionalSaving.get();
            Assertions.assertThat(savingAccount1).isNull();
        }
    }
}