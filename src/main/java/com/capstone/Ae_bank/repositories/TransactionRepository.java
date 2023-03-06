package com.capstone.Ae_bank.repositories;

import com.capstone.Ae_bank.model.CheckingAccount;
import com.capstone.Ae_bank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository  extends JpaRepository<Transaction,Long> {
}
