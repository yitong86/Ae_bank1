package org.yitongJiang.Ae_bank.repositories;

import org.yitongJiang.Ae_bank.model.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// save Account repo work with database
public interface SavingAccountRepository extends JpaRepository<SavingAccount,Long> {
    @Query(value = "select * from savingAccount where id = :id", nativeQuery = true)
    SavingAccount getSavingById(@Param("id") Long id);
}
