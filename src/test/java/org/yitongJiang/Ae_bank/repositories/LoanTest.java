package org.yitongJiang.Ae_bank.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.yitongJiang.Ae_bank.model.CheckingAccount;
import org.yitongJiang.Ae_bank.model.Loan;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class LoanTest {
    @Autowired
    private LoanRepository loanRepository;

    @Test
    public void saveLoan(){

                Loan loan = Loan.builder()
                        .loanNumber(122)
                        .dueDate("03/09/2023")
                .build();
        loanRepository.save(loan);
        Assertions.assertThat(loan.getId()).isGreaterThan(0);
    }
    @Test
    public void getListOfLoanTest(){
        List<Loan> loans = loanRepository.findAll();
        Assertions.assertThat(loans.size()).isGreaterThan(0);
    }
    @Test
    public void updateLoanTest() {
        Loan loan = loanRepository.findById(1L).orElse(new Loan());
        loan.setLoanNumber(9);

        Loan loan1 = loanRepository.save(loan);
        Assertions.assertThat(loan1.getLoanNumber()).isEqualTo(9);

    }
    @Test
    public void deleteCustomerTest(){
        Loan loan = loanRepository.findById(1L).orElse(new Loan());
        loanRepository.delete(loan);

        Loan loan1= null;
        Optional<Loan> optionalChecking = loanRepository.findById(1L);
        if(optionalChecking.isPresent()){
            loan1 = optionalChecking.get();
            Assertions.assertThat(loan1).isNull();
        }
    }

}
