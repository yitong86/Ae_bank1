package org.yitongJiang.Ae_bank.repositories;


import org.yitongJiang.Ae_bank.model.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// CheckingAccount repo work with database
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount,Long> {
    @Query(value = "select * from checkingAccount where id = :id", nativeQuery = true)
    CheckingAccount getCheckingById(@Param("id") Long id);
}
