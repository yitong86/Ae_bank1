package com.capstone.Ae_bank.repositories;

import com.capstone.Ae_bank.model.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SavingAccountRepository extends JpaRepository<SavingAccount,Long> {
    @Query(value = "select * from savingAccount where id = :id", nativeQuery = true)
    SavingAccount getSavingById(@Param("id") Long id);
}
