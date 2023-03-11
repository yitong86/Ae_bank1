package com.capstone.Ae_bank.repositories;


import com.capstone.Ae_bank.model.CheckingAccount;
import com.capstone.Ae_bank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount,Long> {
    @Query(value = "select * from checkingAccount where id = :id", nativeQuery = true)
    CheckingAccount getCheckingById(@Param("id") Long id);
}
