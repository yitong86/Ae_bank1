package org.yitongJiang.Ae_bank.repositories;

import org.yitongJiang.Ae_bank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
// transaction repo work with database
public interface TransactionRepository  extends JpaRepository<Transaction,Long> {
}
